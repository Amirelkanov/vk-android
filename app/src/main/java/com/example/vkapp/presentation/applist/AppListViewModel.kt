package com.example.vkapp.presentation.applist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkapp.data.applist.AppListRepositoryImpl
import com.example.vkapp.domain.applist.AppListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppListViewModel @Inject constructor(
    private val appListRepository: AppListRepositoryImpl
) : ViewModel() {

    private val _state = MutableStateFlow<AppListState>(AppListState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<AppListEvent>(BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        getAppList()
    }

    fun showAppTitleMessage(app: AppListItem) {
        viewModelScope.launch {
            _events.send(AppListEvent.ShowAppTitle(app.name))
        }
    }

    fun getAppList() {
        viewModelScope.launch {
            _state.value = AppListState.Loading

            runCatching {
                val appList = appListRepository.get()

                _state.value = AppListState.Content(appList)
            }.onFailure {
                Log.d("HOHOHO", "ERROR : $it")
                _state.value = AppListState.Error
            }
        }
    }
}