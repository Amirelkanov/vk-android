package com.example.vkapp.data.appdetails

import com.example.vkapp.domain.appdetails.AppDetails


class AppDetailsMapper {
    fun toDomain(dto: AppDetailsDto): AppDetails = AppDetails(
        name = dto.name,
        developer = dto.developer,
        category = dto.category,
        ageRating = dto.ageRating,
        size = dto.size.toFloat(),
        iconUrl = dto.icon,
        screenshotUrlList = dto.screenshots,
        description = dto.description,
    )
}