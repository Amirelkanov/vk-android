package com.example.vkapp.presentation.applist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkapp.R
import com.example.vkapp.presentation.theme.VkAppTheme

@Composable
fun AppListError(
    onRefreshClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.app_details_error),
            fontStyle = MaterialTheme.typography.headlineMedium.fontStyle,
            color = MaterialTheme.colorScheme.tertiary,
        )
        Spacer(Modifier.height(12.dp))
        Button(
            onClick = onRefreshClick,
        ) {
            Text(text = stringResource(R.string.app_details_error_refresh))
        }
    }
}

@Preview
@Composable
private fun Preview() {
    VkAppTheme {
        AppListError(
            onRefreshClick = {},
            modifier = Modifier.fillMaxSize(),
        )
    }
}