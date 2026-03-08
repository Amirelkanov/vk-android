package com.example.vkapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.net.toUri
import com.example.vkapp.ui.screens.MainScreen
import com.example.vkapp.ui.theme.VKAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            VKAppTheme {
                MainScreen(
                    openSecondActivity = { text ->
                        val intent = SecondActivity.createIntent(this, text)

                        startActivity(intent)
                    },

                    dialPhone = { phone ->
                        val intent = Intent(Intent.ACTION_DIAL, "tel:$phone".toUri())

                        startActivity(intent)
                    },

                    shareText = { textToShare ->
                        val intent = Intent(Intent.ACTION_SEND).apply {
                            putExtra(Intent.EXTRA_TEXT, textToShare)
                            type = "text/plain"
                        }
                        val shareIntent = Intent.createChooser(intent, null)

                        startActivity(shareIntent)
                    }
                )
            }
        }
    }
}
