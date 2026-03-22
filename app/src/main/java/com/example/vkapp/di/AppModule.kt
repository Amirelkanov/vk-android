package com.example.vkapp.di

import com.example.vkapp.data.appdetails.AppDetailsRepositoryImpl
import com.example.vkapp.data.applist.AppListRepositoryImpl
import com.example.vkapp.domain.appdetails.AppDetailsRepository
import com.example.vkapp.domain.applist.AppListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Binds
    @Singleton
    fun bindAppDetailsRepository(impl: AppDetailsRepositoryImpl): AppDetailsRepository

    @Binds
    @Singleton
    fun bindAppListRepository(impl: AppListRepositoryImpl): AppListRepository
}