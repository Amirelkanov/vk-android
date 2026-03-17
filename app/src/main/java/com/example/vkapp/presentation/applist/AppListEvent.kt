package com.example.vkapp.presentation.applist

sealed interface AppListEvent {
    data class ShowAppTitle(val title: String) : AppListEvent
}