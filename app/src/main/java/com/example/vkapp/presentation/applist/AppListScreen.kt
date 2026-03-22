package com.example.vkapp.presentation.applist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.vkapp.presentation.theme.RuStoreBlue
import kotlinx.coroutines.flow.Flow

@Composable
fun AppListScreen(
    onAppClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AppListViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val events = viewModel.events

    val snackbarHostState = remember { SnackbarHostState() }

    ObserveEvents(
        events = events,
        snackbarHostState = snackbarHostState,
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = RuStoreBlue,
        topBar = {
            AppListTopBar(
                onGridClick = { },
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 28.dp)
            )
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) { innerPadding ->
        when (val currentState = state) {
            is AppListState.Loading -> {
                AppListLoading(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = innerPadding.calculateTopPadding())
                )
            }

            is AppListState.Error -> {
                AppListError(
                    onRefreshClick = { viewModel.getAppList() },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = innerPadding.calculateTopPadding())
                )
            }

            is AppListState.Content -> {
                AppList(
                    items = currentState.appList,
                    onClick = { onAppClick() },
                    onLogoClick = { viewModel.showAppTitleMessage(it) },
                    innerPadding = innerPadding,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = innerPadding.calculateTopPadding())
                        .clip(
                            RoundedCornerShape(
                                topStart = 16.dp,
                                topEnd = 16.dp
                            )
                        )
                        .background(color = colorScheme.surface)
                )
            }
        }
    }

}

@Composable
private fun ObserveEvents(
    events: Flow<AppListEvent>,
    snackbarHostState: SnackbarHostState,
) {
    LaunchedEffect(Unit) {
        events.collect { event ->
            when (event) {
                is AppListEvent.ShowAppTitle -> {
                    snackbarHostState.showSnackbar(event.title)
                }
            }
        }
    }
}