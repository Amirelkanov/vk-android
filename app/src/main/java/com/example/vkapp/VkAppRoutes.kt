package com.example.vkapp

interface VkAppRoutes {
    val route: String
}

object AppList : VkAppRoutes {
    override val route = "app_list"
}

object AppDetails : VkAppRoutes {
    override val route = "app_details"
}