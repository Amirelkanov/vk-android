package com.example.vkapp.data.applist

import com.example.vkapp.domain.Category

data class AppListItemDto(
    val id: String,
    val name: String,
    val iconUrl: String,
    val shortDescription: String,
    val category: Category
)