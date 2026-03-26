package com.example.vkapp.domain.appdetails

import com.example.vkapp.domain.Category
import javax.inject.Inject

class GetAppDetailsUseCase @Inject constructor(
    private val appDetailsRepository: AppDetailsRepository,
) {
    suspend operator fun invoke(id: String): AppDetails {
        val app: AppDetails = appDetailsRepository.get(id)

        if (app.category == Category.GAME) {
            throw IllegalStateException()
        }

        return app
    }
}