package com.example.vkapp.presentation.applist

import androidx.compose.runtime.Immutable
import com.example.vkapp.domain.applist.AppListItem

@Immutable
sealed interface AppListState {
    data object Error : AppListState
    data object Loading : AppListState
    data class Content(
        val appList: List<AppListItem>,
    ) : AppListState
}