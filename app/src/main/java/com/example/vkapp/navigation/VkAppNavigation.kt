package com.example.vkapp.navigation

import androidx.compose.runtime.Composable
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
                onAppClick = { id -> navController.navigateToSingleAppDetails(id) },
            )
        }
        composable(
            route = AppDetails.routeWithArgs,
            arguments = AppDetails.arguments
        ) {
            AppDetailsScreen(
                onBackClick = { navController.popBackStack() },
            )
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }

private fun NavHostController.navigateToSingleAppDetails(appId: String) =
    this.navigateSingleTopTo("${AppDetails.route}/$appId")