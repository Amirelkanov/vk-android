package com.example.vkapp.presentation.applist

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkapp.domain.applist.AppListItem

@Composable
fun AppList(
    items: List<AppListItem>,
    onAppClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(items) { index, item ->
            AppListItem(
                appListItem = item,
                onClick = onAppClick,
            )

            if (index < items.size - 1) {
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = colorScheme.onSurface.copy(alpha = 0.12f)
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    AppList(
        items = listOf(
            AppListItem(
                id = "1",
                name = "Приложение 1",
                iconUrl = "https://platforms.su/storage/product-logo/1755356939_YFj3rQuKeP.png",
                shortDescription = "Краткое описание приложения 1",
                category = com.example.vkapp.domain.common.Category.APP
            ),
            AppListItem(
                id = "2",
                name = "Приложение 2",
                iconUrl = "https://platforms.su/storage/product-logo/1755356939_YFj3rQuKeP.png",
                shortDescription = "Краткое описание приложения 2",
                category = com.example.vkapp.domain.common.Category.APP
            ),
            AppListItem(
                id = "3",
                name = "Приложение 3",
                iconUrl = "https://platforms.su/storage/product-logo/1755356939_YFj3rQuKeP.png",
                shortDescription = "Краткое описание приложения 3",
                category = com.example.vkapp.domain.common.Category.APP
            ),
        ),
        onAppClick = {},
    )
}
