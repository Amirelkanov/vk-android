package com.example.vkapp.data.applist

import com.example.vkapp.data.network.AppApi
import com.example.vkapp.domain.Category
import com.example.vkapp.domain.applist.AppListItem
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AppListRepositoryImplTest {

    private val appApi: AppApi = mockk()
    private val mapper: AppListMapper = mockk()

    private lateinit var repository: AppListRepositoryImpl

    @BeforeEach
    fun setUp() {
        repository = AppListRepositoryImpl(appApi, mapper)
    }

    @Test
    fun `get returns mapped domain list`() = runTest {
        val dtoList = listOf(
            AppListItemDto(
                id = "1",
                name = "App One",
                iconUrl = "https://example.com/icon.png",
                shortDescription = "Desc 1",
                category = Category.APP
            )
        )
        val domainList = listOf(
            AppListItem(
                id = "1",
                name = "App One",
                iconUrl = "https://example.com/icon.png",
                shortDescription = "Desc 1",
                category = Category.APP
            )
        )

        coEvery { appApi.getAppList() } returns dtoList
        coEvery { mapper.toDomainList(dtoList) } returns domainList

        val result = repository.get()

        assertEquals(domainList, result)
        coVerify(exactly = 1) { appApi.getAppList() }
        coVerify(exactly = 1) { mapper.toDomainList(dtoList) }
    }

    @Test
    fun `get returns empty list when api returns empty`() = runTest {
        coEvery { appApi.getAppList() } returns emptyList()
        coEvery { mapper.toDomainList(emptyList()) } returns emptyList()

        val result = repository.get()

        assertEquals(emptyList<AppListItem>(), result)
    }

    @Test
    fun `get throws when api fails`() = runTest {
        coEvery { appApi.getAppList() } throws RuntimeException("Network error")

        assertThrows<RuntimeException> {
            repository.get()
        }
    }
}
