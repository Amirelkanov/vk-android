package com.example.vkapp.data.appdetails

import com.example.vkapp.data.network.AppApi
import com.example.vkapp.domain.appdetails.AppDetails
import com.example.vkapp.domain.appdetails.AppDetailsRepository
import javax.inject.Inject


class AppDetailsRepositoryImpl @Inject constructor(
    private val appApi: AppApi,
    private val mapper: AppDetailsMapper
) : AppDetailsRepository {
    override suspend fun get(id: String): AppDetails {
        val dto = appApi.getAppDetails(id)
        val domain = mapper.toDomain(dto)
        return domain
    }
}