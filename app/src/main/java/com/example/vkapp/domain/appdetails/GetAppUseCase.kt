package com.example.vkapp.domain.appdetails

import com.example.vkapp.domain.Category
import javax.inject.Inject

class GetAppDetailsUseCase @Inject constructor(
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