package com.example.vkapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.vkapp.presentation.appdetails.AppDetailsScreen
import com.example.vkapp.presentation.applist.AppListScreen

@Composable
fun VkAppNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = AppList.route,
    ) {
        composable(AppList.route) {
            AppListScreen(
                onAppClick = {
                    navController.navigate(AppDetails.route)
                },
            )
        }
        composable(AppDetails.route) {
            AppDetailsScreen(
                onBackClick = { navController.popBackStack() },
            )
        }
    }
}