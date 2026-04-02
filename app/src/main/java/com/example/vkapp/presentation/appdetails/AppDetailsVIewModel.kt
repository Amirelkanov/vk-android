package com.example.vkapp.presentation.appdetails

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkapp.domain.appdetails.AppDetailsRepository
import com.example.vkapp.navigation.AppDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    private val appDetailsRepository: AppDetailsRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    // Лучше в худшем случае падать - если у нас нет такого аргумента,
    // то непонятно, какое поведение мы от ViewModel ждем
    private val appId: String = checkNotNull(savedStateHandle[AppDetails.APP_ID_ARG])

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<AppDetailsEvent>(BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        observeAppDetails()
        getAppDetails()
    }

    fun showUnderDevelopmentMessage() {
        viewModelScope.launch {
            _events.send(AppDetailsEvent.UnderDevelopment)
        }
    }

    fun collapseDescription() {
        _state.update { currentState ->
            if (currentState is AppDetailsState.Content) {
                currentState.copy(descriptionCollapsed = true)
            } else {
                currentState
            }
        }
    }

    fun toggleWishlist() {
        viewModelScope.launch {
            appDetailsRepository.toggleWishlist(appId)
        }
    }

    fun getAppDetails() {
        viewModelScope.launch {
            _state.value = AppDetailsState.Loading

            appDetailsRepository.get(appId).catch { e ->
                _state.value = AppDetailsState.Error
                Log.d("HOHOHO", "ERROR $e")
            }.collect { }
        }
    }

    private fun observeAppDetails() {
        viewModelScope.launch {
            appDetailsRepository.observeAppDetails(appId)
                .catch {
                    _state.value = AppDetailsState.Error
                }
                .collect { appDetails ->
                    _state.value = AppDetailsState.Content(
                        appDetails = appDetails,
                        descriptionCollapsed = false
                    )
                }
        }
    }
}
