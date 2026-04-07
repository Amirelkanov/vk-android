package com.example.vkapp.data.appdetails

import com.example.vkapp.data.appdetails.local.AppDetailsEntity
import com.example.vkapp.data.appdetails.local.AppDetailsEntityMapper
import com.example.vkapp.domain.Category
import com.example.vkapp.domain.appdetails.AppDetails
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AppDetailsEntityMapperTest {

    private val mapper = AppDetailsEntityMapper()

    private fun createDomain(
        id: String = "com.example.app",
        name: String = "Test App",
        developer: String = "Test Dev",
        category: Category = Category.APP,
        ageRating: Int = 12,
        size: Float = 45.5f,
        iconUrl: String = "https://example.com/icon.png",
        screenshotUrlList: List<String>? = listOf("https://example.com/a.png"),
        description: String = "A test application",
        isInWishlist: Boolean = false,
    ) = AppDetails(
        id = id,
        name = name,
        developer = developer,
        category = category,
        ageRating = ageRating,
        size = size,
        iconUrl = iconUrl,
        screenshotUrlList = screenshotUrlList,
        description = description,
        isInWishlist = isInWishlist,
    )

    private fun createEntity(
        id: String = "com.example.app",
        name: String = "Test App",
        developer: String = "Test Dev",
        category: Category = Category.APP,
        ageRating: Int = 12,
        size: Float = 45.5f,
        iconUrl: String = "https://example.com/icon.png",
        screenshots: String? = null,
        description: String = "A test application",
        isInWishlist: Boolean = false,
    ) = AppDetailsEntity(
        id = id,
        name = name,
        developer = developer,
        category = category,
        ageRating = ageRating,
        size = size,
        iconUrl = iconUrl,
        screenshots = screenshots,
        description = description,
        isInWishlist = isInWishlist,
    )

    // --- toEntity ---

    @Test
    fun `toEntity maps all basic fields correctly`() {
        val domain = createDomain()
        val entity = mapper.toEntity(domain)

        assertEquals(domain.id, entity.id)
        assertEquals(domain.name, entity.name)
        assertEquals(domain.developer, entity.developer)
        assertEquals(domain.category, entity.category)
        assertEquals(domain.ageRating, entity.ageRating)
        assertEquals(domain.size, entity.size)
        assertEquals(domain.iconUrl, entity.iconUrl)
        assertEquals(domain.description, entity.description)
        assertEquals(domain.isInWishlist, entity.isInWishlist)
    }

    // NOTE: ЭТО НЕ Я ТАК ЗАХОТЕЛ, ТАК НА ПРАКТИКЕ СДЕЛАНО
    @Test
    fun `toEntity always sets screenshots to null`() {
        val domain = createDomain(screenshotUrlList = listOf("https://example.com/a.png"))
        val entity = mapper.toEntity(domain)
        assertNull(entity.screenshots)
    }

    @Test
    fun `toEntity preserves isInWishlist true`() {
        val entity = mapper.toEntity(createDomain(isInWishlist = true))
        assertTrue(entity.isInWishlist)
    }

    // toDomain

    @Test
    fun `toDomain maps all basic fields correctly`() {
        val entity = createEntity()
        val domain = mapper.toDomain(entity)

        assertEquals(entity.id, domain.id)
        assertEquals(entity.name, domain.name)
        assertEquals(entity.developer, domain.developer)
        assertEquals(entity.category, domain.category)
        assertEquals(entity.ageRating, domain.ageRating)
        assertEquals(entity.size, domain.size)
        assertEquals(entity.iconUrl, domain.iconUrl)
        assertEquals(entity.description, domain.description)
        assertEquals(entity.isInWishlist, domain.isInWishlist)
    }

    @Test
    fun `toDomain always sets screenshotUrlList to null`() {
        val entity = createEntity(screenshots = "blah blah")
        val domain = mapper.toDomain(entity)
        assertNull(domain.screenshotUrlList)
    }

    @Test
    fun `toDomain preserves isInWishlist true`() {
        val domain = mapper.toDomain(createEntity(isInWishlist = true))
        assertTrue(domain.isInWishlist)
    }

    // toEntity then toDomain

    @Test
    fun `toEntity then toDomain preserves all non-screenshot fields`() {
        val original = createDomain(isInWishlist = true)
        val result = mapper.toDomain(mapper.toEntity(original))

        assertEquals(original.id, result.id)
        assertEquals(original.name, result.name)
        assertEquals(original.developer, result.developer)
        assertEquals(original.category, result.category)
        assertEquals(original.ageRating, result.ageRating)
        assertEquals(original.size, result.size)
        assertEquals(original.iconUrl, result.iconUrl)
        assertEquals(original.description, result.description)
        assertEquals(original.isInWishlist, result.isInWishlist)
    }
}