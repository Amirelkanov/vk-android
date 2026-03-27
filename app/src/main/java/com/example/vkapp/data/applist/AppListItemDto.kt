package com.example.vkapp.data.applist

import com.example.vkapp.domain.Category
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppListItemDto(
    val id: String,
    val name: String,
    val iconUrl: String,
    @SerialName("description")
    val shortDescription: String,
    val category: Category
)