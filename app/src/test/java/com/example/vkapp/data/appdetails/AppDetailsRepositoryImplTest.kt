package com.example.vkapp.data.appdetails

import com.example.vkapp.data.appdetails.local.AppDetailsDao
import com.example.vkapp.data.appdetails.local.AppDetailsEntity
import com.example.vkapp.data.appdetails.local.AppDetailsEntityMapper
import com.example.vkapp.data.network.AppApi
import com.example.vkapp.domain.Category
import com.example.vkapp.domain.appdetails.AppDetails
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AppDetailsRepositoryImplTest {

    private val appApi: AppApi = mockk()
    private val dao: AppDetailsDao = mockk()
    private val mapper: AppDetailsMapper = mockk()
    private val entityMapper: AppDetailsEntityMapper = mockk()

    private lateinit var repository: AppDetailsRepositoryImpl

    // Test data

    private val testId = "app_123"

    private val testDomain = AppDetails(
        id = testId,
        name = "Test App",
        developer = "Test Dev",
        category = Category.APP,
        ageRating = 12,
        size = 45.5f,
        iconUrl = "https://example.com/icon.png",
        screenshotUrlList = listOf("https://example.com/a.png"),
        description = "Test description",
        isInWishlist = false
    )

    private val testEntity = AppDetailsEntity(
        id = testId,
        name = "Test App",
        developer = "Test Dev",
        category = Category.APP,
        ageRating = 12,
        size = 45.5f,
        iconUrl = "https://example.com/icon.png",
        screenshots = "https://example.com/a.png",
        description = "Test description",
        isInWishlist = false
    )

    private val testDto = AppDetailsDto(
        id = testId,
        name = "Test App",
        developer = "Test Dev",
        category = Category.APP,
        ageRating = 12,
        size = 45.5,
        iconUrl = "https://example.com/icon.png",
        screenshots = listOf("https://example.com/a.png"),
        description = "Test description"
    )

    @BeforeEach
    fun setUp() {
        repository = AppDetailsRepositoryImpl(appApi, dao, mapper, entityMapper)
    }

    // get

    @Test
    fun `get emits domain from cache when entity exists in dao`() = runTest {
        every { dao.getAppDetails(testId) } returns flowOf(testEntity)
        every { entityMapper.toDomain(testEntity) } returns testDomain

        val result = repository.get(testId).first()

        assertEquals(testDomain, result)
        coVerify(exactly = 0) { appApi.getAppDetails(any()) }
    }

    @Test
    fun `get fetches from network and saves to dao when entity is null`() = runTest {
        every { dao.getAppDetails(testId) } returns flowOf(null)
        coEvery { appApi.getAppDetails(testId) } returns testDto
        every { mapper.toDomain(testDto) } returns testDomain
        every { entityMapper.toEntity(testDomain) } returns testEntity
        every { dao.insertAppDetails(testEntity) } returns Unit

        val result = repository.get(testId).first()

        assertEquals(testDomain, result)
        coVerify(exactly = 1) { appApi.getAppDetails(testId) }
        verify(exactly = 1) { dao.insertAppDetails(testEntity) }
    }

    // toggleWishlist

    @Test
    fun `toggleWishlist sets wishlist to true when currently false`() = runTest {
        val entityNotInWishlist = testEntity.copy(isInWishlist = false)
        every { dao.getAppDetails(testId) } returns flowOf(entityNotInWishlist)
        coEvery { dao.updateWishlistStatus(testId, true) } returns Unit

        repository.toggleWishlist(testId)

        coVerify(exactly = 1) { dao.updateWishlistStatus(testId, true) }
    }

    @Test
    fun `toggleWishlist sets wishlist to false when currently true`() = runTest {
        val entityInWishlist = testEntity.copy(isInWishlist = true)
        every { dao.getAppDetails(testId) } returns flowOf(entityInWishlist)
        coEvery { dao.updateWishlistStatus(testId, false) } returns Unit

        repository.toggleWishlist(testId)

        coVerify(exactly = 1) { dao.updateWishlistStatus(testId, false) }
    }

    @Test
    fun `toggleWishlist does nothing when entity is null`() = runTest {
        every { dao.getAppDetails(testId) } returns flowOf(null)

        repository.toggleWishlist(testId)

        coVerify(exactly = 0) { dao.updateWishlistStatus(any(), any()) }
    }

    // observeAppDetails

    @Test
    fun `observeAppDetails emits domain when entity is not null`() = runTest {
        every { dao.getAppDetails(testId) } returns flowOf(testEntity)
        every { entityMapper.toDomain(testEntity) } returns testDomain

        val result = repository.observeAppDetails(testId).first()

        assertEquals(testDomain, result)
    }

    @Test
    fun `observeAppDetails skips null entities`() = runTest {
        every { dao.getAppDetails(testId) } returns flowOf(null, testEntity)
        every { entityMapper.toDomain(testEntity) } returns testDomain

        val result = repository.observeAppDetails(testId).first()

        assertEquals(testDomain, result)
        verify(exactly = 1) { entityMapper.toDomain(testEntity) }
    }
}
