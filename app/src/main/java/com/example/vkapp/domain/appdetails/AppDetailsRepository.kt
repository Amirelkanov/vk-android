package com.example.vkapp.domain.appdetails

interface AppDetailsRepository {
    suspend fun get(id: String): AppDetails
}