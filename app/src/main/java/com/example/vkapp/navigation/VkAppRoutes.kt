package com.example.vkapp.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

interface VkAppRoutes {
    val route: String
}

interface VkAppDetailedRoutes {
    val arguments: List<NamedNavArgument>
    val route: String
}

object AppList : VkAppRoutes {
    override val route = "app_list"
}

object AppDetails : VkAppDetailedRoutes {
    const val APP_ID_ARG = "app_id"

    override val route = "app_details"
    override val arguments = listOf(navArgument(APP_ID_ARG) { type = NavType.StringType })
    val routeWithArgs = "$route/{$APP_ID_ARG}"
}
