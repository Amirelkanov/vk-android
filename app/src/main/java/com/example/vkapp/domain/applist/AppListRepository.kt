package com.example.vkapp.domain.applist


interface AppListRepository {
    suspend fun get(): List<AppListItem>
}