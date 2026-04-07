package com.example.vkapp.data.applist


import com.example.vkapp.domain.Category
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AppListMapperTest {

    private val mapper = AppListMapper()

    private fun createDto(
        id: String = "com.example.app",
        name: String = "Test App",
        iconUrl: String = "https://example.com/icon.png",
        shortDescription: String = "Short description",
        category: Category = Category.APP,
    ) = AppListItemDto(
        id = id,
        name = name,
        iconUrl = iconUrl,
        shortDescription = shortDescription,
        category = category,
    )

    @Test
    fun `toDomain maps all fields correctly`() {
        val dto = createDto()
        val domain = mapper.toDomain(dto)

        assertEquals(dto.id, domain.id)
        assertEquals(dto.name, domain.name)
        assertEquals(dto.iconUrl, domain.iconUrl)
        assertEquals(dto.shortDescription, domain.shortDescription)
        assertEquals(dto.category, domain.category)
    }

    @Test
    fun `toDomainList maps each item in the list`() {
        val dtos = listOf(
            createDto(id = "app.one", name = "One"),
            createDto(id = "app.two", name = "Two"),
            createDto(id = "app.three", name = "Three"),
        )
        val result = mapper.toDomainList(dtos)

        assertEquals(3, result.size)
        assertEquals("app.one", result[0].id)
        assertEquals("app.two", result[1].id)
        assertEquals("app.three", result[2].id)
    }

    @Test
    fun `toDomainList returns empty list for empty input`() {
        val result = mapper.toDomainList(emptyList())
        assertTrue(result.isEmpty())
    }

    @Test
    fun `toDomainList preserves order`() {
        val dtos = (1..5).map { createDto(id = "app.$it", name = "App $it") }
        val result = mapper.toDomainList(dtos)
        result.forEachIndexed { index, item ->
            assertEquals("app.${index + 1}", item.id)
        }
    }
}