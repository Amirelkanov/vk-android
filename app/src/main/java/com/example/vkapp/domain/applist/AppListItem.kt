package com.example.vkapp.domain.applist

import com.example.vkapp.domain.Category

data class AppListItem(
    val id: String,
    val name: String,
    val iconUrl: String,
    val shortDescription: String,
    val category: Category
)