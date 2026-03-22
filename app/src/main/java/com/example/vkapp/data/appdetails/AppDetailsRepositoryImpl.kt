package com.example.vkapp.data.appdetails

import com.example.vkapp.data.AppApi
import com.example.vkapp.domain.appdetails.AppDetails
import com.example.vkapp.domain.appdetails.AppDetailsRepository
import javax.inject.Inject


class AppDetailsRepositoryImpl @Inject constructor(
    private val appApi: AppApi,
    private val mapper: AppDetailsMapper
) : AppDetailsRepository {
    override suspend fun get(): AppDetails {
        val dto = appApi.getAppDetails()
        val domain = mapper.toDomain(dto)
        return domain
    }
}