package com.example.vkapp.presentation.applist

import androidx.compose.foundation.layout.PaddingValues
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
import com.example.vkapp.domain.common.Category

@Composable
fun AppList(
    items: List<AppListItem>,
    innerPadding: PaddingValues,
    onAppClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(bottom = innerPadding.calculateBottomPadding())
    ) {
        itemsIndexed(items) { index, item ->
            AppListItem(
                appListItem = item,
                onClick = onAppClick,
            )

            if (index < items.size - 1) {
                HorizontalDivider(
                    thickness = 2.dp,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = colorScheme.onSurface.copy(alpha = 0.04f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    AppList(
        items = listOf(
            AppListItem(
                id = "1",
                name = "Приложение 1",
                iconUrl = "https://platforms.su/storage/product-logo/1755356939_YFj3rQuKeP.png",
                shortDescription = "Краткое описание приложения 1",
                category = Category.APP
            ),
            AppListItem(
                id = "2",
                name = "Приложение 2",
                iconUrl = "https://platforms.su/storage/product-logo/1755356939_YFj3rQuKeP.png",
                shortDescription = "Краткое описание приложения 2",
                category = Category.APP
            ),
            AppListItem(
                id = "3",
                name = "Приложение 3",
                iconUrl = "https://platforms.su/storage/product-logo/1755356939_YFj3rQuKeP.png",
                shortDescription = "Краткое описание приложения 3",
                category = Category.APP
            ),
        ),
        innerPadding = PaddingValues(0.dp),
        onAppClick = {},
    )
}
