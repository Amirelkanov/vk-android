package com.example.vkapp.ui.screens

import android.util.Patterns
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.vkapp.R

@Composable
fun MainScreen(
    openSecondActivity: (String) -> Unit,
    dialPhone: (String) -> Unit,
    shareText: (String) -> Unit
) {
    var text by rememberSaveable { mutableStateOf("") }
    var isPhoneError by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = text,
            onValueChange = {
                text = it
                isPhoneError = false
            },
            maxLines = 3,
            label = { Text(stringResource(R.string.text_field_label)) },
            isError = isPhoneError,
            modifier = Modifier.fillMaxWidth()
        )

        if (isPhoneError) {
            Text(
                text = stringResource(R.string.phone_error_message),
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { openSecondActivity(text) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.button_open_second_activity))
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    if (Patterns.PHONE.matcher(text).matches()) {
                        dialPhone(text)
                    } else {
                        isPhoneError = true
                    }
                },
            ) {
                Text(stringResource(R.string.button_call_friend))
            }

            Button(
                onClick = { shareText(text) },
                modifier = Modifier.weight(1f)
            ) {
                Text(stringResource(R.string.button_share_text))
            }
        }
    }
}