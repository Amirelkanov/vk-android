package com.example.vkapp.presentation.applist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import com.example.vkapp.domain.applist.AppListItem
import com.example.vkapp.domain.common.Category
import com.example.vkapp.presentation.theme.RuStoreBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppListScreen(
    onAppClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val appList = remember { getAppList() }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = RuStoreBlue,
        topBar = {
            Toolbar(
                onGridClick = { },
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 28.dp)
            )
        }
    ) { innerPadding ->
        AppList(
            items = appList,
            onAppClick = { onAppClick() }, // NOTE: Надо тут id, наверное, прокидывать, но пока так
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .clip(
                    RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp
                    )
                )
                .background(color = MaterialTheme.colorScheme.surface)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AppListScreenPreview() {
    AppListScreen({})
}

private fun getAppList(): List<AppListItem> {
    return listOf(
        AppListItem(
            id = "1",
            name = "Приложение 1",
            iconUrl = "https://example.com/icon1.png",
            shortDescription = "Краткое описание приложения 1",
            category = Category.APP
        ),
        AppListItem(
            id = "2",
            name = "Игра 1",
            iconUrl = "https://example.com/icon2.png",
            shortDescription = "Краткое описание игры 1",
            category = Category.GAME
        )
    )
}