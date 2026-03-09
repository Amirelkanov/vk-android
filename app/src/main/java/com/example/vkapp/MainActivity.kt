package com.example.vkapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.ui.Modifier
import com.example.vkapp.presentation.appdetails.AppDetailsScreen
import com.example.vkapp.presentation.theme.VkAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkAppTheme {
                AppDetailsScreen(
                    Modifier
                        .fillMaxSize()
                        .safeDrawingPadding()
                )
            }
        }
    }
}