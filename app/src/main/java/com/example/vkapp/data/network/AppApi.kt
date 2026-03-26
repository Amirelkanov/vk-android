package com.example.vkapp.data.network

import com.example.vkapp.data.appdetails.AppDetailsDto
import com.example.vkapp.data.applist.AppListItemDto
import retrofit2.http.GET
import retrofit2.http.Path

interface AppApi {
    @GET("catalog/{id}")
    suspend fun getAppDetails(@Path("id") id: String): AppDetailsDto

    @GET("catalog")
    suspend fun getAppList(): List<AppListItemDto>
}