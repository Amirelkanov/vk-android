package com.example.vkapp.data.applist

import com.example.vkapp.domain.applist.AppListItem
import kotlin.collections.map


class AppListMapper {
    fun toDomain(dto: AppListItemDto): AppListItem = AppListItem(
        id = dto.id,
        name = dto.name,
        iconUrl = dto.iconUrl,
        shortDescription = dto.shortDescription,
        category = dto.category
    )

    fun toDomainList(dto: List<AppListItemDto>): List<AppListItem> =
        dto.map { toDomain(it) }
}