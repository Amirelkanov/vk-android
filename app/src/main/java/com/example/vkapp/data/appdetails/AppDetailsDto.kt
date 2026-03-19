package com.example.vkapp.data.appdetails

import com.example.vkapp.domain.Category

data class AppDetailsDto(
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Double,
    val icon: String,
    val screenshots: List<String>,
    val description: String,
)