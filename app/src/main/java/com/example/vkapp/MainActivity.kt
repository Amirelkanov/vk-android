package com.example.vkapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.vkapp.navigation.VkAppNavHost
import com.example.vkapp.presentation.theme.VkAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            VkAppTheme {
                val navController = rememberNavController()

                VkAppNavHost(
                    navController = navController,
                )
            }
        }
    }
}