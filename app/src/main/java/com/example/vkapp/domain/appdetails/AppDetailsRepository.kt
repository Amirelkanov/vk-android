package com.example.vkapp.domain.appdetails

import kotlinx.coroutines.flow.Flow

interface AppDetailsRepository {
    suspend fun get(id: String): Flow<AppDetails>

    suspend fun toggleWishlist(id: String)

    fun observeAppDetails(id: String): Flow<AppDetails>
}