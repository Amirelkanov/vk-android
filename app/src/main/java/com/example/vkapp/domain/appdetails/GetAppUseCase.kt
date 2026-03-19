package com.example.vkapp.domain.appdetails

import com.example.vkapp.domain.Category

class GetAppDetailsUseCase(
    private val appDetailsRepository: AppDetailsRepository,
) {
    suspend operator fun invoke(): AppDetails {
        val app: AppDetails = appDetailsRepository.get()

        if (app.category == Category.GAME) {
            throw IllegalStateException()
        }

        return app
    }
}