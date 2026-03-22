package com.example.vkapp.data.applist

import com.example.vkapp.data.AppApi
import com.example.vkapp.domain.applist.AppListItem
import com.example.vkapp.domain.applist.AppListRepository
import javax.inject.Inject


class AppListRepositoryImpl @Inject constructor(
    private val appApi: AppApi,
    private val mapper: AppListMapper
) : AppListRepository {
    override suspend fun get(): List<AppListItem> {
        val dto = appApi.getAppList()
        val domain = mapper.toDomainList(dto)
        return domain
    }
}