package com.example.vkapp.data.appdetails

import com.example.vkapp.domain.appdetails.AppDetails
import javax.inject.Inject


class AppDetailsMapper @Inject constructor() {
    fun toDomain(dto: AppDetailsDto): AppDetails = AppDetails(
        id = dto.id,
        name = dto.name,
        developer = dto.developer,
        category = dto.category,
        ageRating = dto.ageRating,
        size = dto.size.toFloat(),
        iconUrl = dto.iconUrl,
        screenshotUrlList = dto.screenshots,
        description = dto.description,

    )
}