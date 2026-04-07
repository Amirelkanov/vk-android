package com.example.vkapp.data.appdetails

import com.example.vkapp.domain.Category
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AppDetailsMapperTest {

    private val mapper = AppDetailsMapper()

    private fun createDto(
        id: String = "com.example.app",
        name: String = "Test App",
        developer: String = "Test Dev",
        category: Category = Category.APP,
        ageRating: Int = 12,
        size: Double = 45.5,
        iconUrl: String = "https://example.com/icon.png",
        screenshots: List<String>? = listOf("https://example.com/a.png"),
        description: String = "A test application",
    ) = AppDetailsDto(
        id = id,
        name = name,
        developer = developer,
        category = category,
        ageRating = ageRating,
        size = size,
        iconUrl = iconUrl,
        screenshots = screenshots,
        description = description,
    )

    @Test
    fun `toDomain maps all fields correctly`() {
        val dto = createDto()
        val domain = mapper.toDomain(dto)

        assertEquals(dto.id, domain.id)
        assertEquals(dto.name, domain.name)
        assertEquals(dto.developer, domain.developer)
        assertEquals(dto.category, domain.category)
        assertEquals(dto.ageRating, domain.ageRating)
        assertEquals(dto.size.toFloat(), domain.size)
        assertEquals(dto.iconUrl, domain.iconUrl)
        assertEquals(dto.screenshots, domain.screenshotUrlList)
        assertEquals(dto.description, domain.description)
    }

    @Test
    fun `toDomain sets size as float conversion of dto double`() {
        val dto = createDto(size = 123.456)
        val domain = mapper.toDomain(dto)
        assertEquals(123.456.toFloat(), domain.size)
    }

    @Test
    fun `toDomain preserves null screenshots`() {
        val dto = createDto(screenshots = null)
        val domain = mapper.toDomain(dto)
        assertNull(domain.screenshotUrlList)
    }

    @Test
    fun `toDomain preserves non-null screenshot list`() {
        val urls = listOf("https://example.com/a.png", "https://example.com/b.png")
        val dto = createDto(screenshots = urls)
        val domain = mapper.toDomain(dto)
        assertEquals(urls, domain.screenshotUrlList)
    }

    @Test
    fun `toDomain does not set isInWishlist (default false)`() {
        val domain = mapper.toDomain(createDto())
        assertFalse(domain.isInWishlist)
    }
}