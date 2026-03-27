package com.example.vkapp.data.appdetails

import com.example.vkapp.domain.Category
import kotlinx.serialization.Serializable

@Serializable
data class AppDetailsDto(
    val id: String,
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Double,
    val iconUrl: String,
    val screenshots: List<String>? = null,
    val description: String,
)