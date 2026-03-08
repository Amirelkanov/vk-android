package com.example.vkapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.vkapp.ui.screens.SecondScreen
import com.example.vkapp.ui.theme.VKAppTheme

class SecondActivity : ComponentActivity() {
    companion object {
        const val SHARED_TEXT = "shared_text"

        fun createIntent(context: Context, text: String) =
            Intent(context, SecondActivity::class.java).apply {
                putExtra(SHARED_TEXT, text)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            VKAppTheme {
                val text = intent.getStringExtra(SHARED_TEXT) ?: ""

                SecondScreen(text)
            }
        }
    }
}
