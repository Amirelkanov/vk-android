package com.example.vkapp.presentation.applist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkapp.domain.applist.AppListItem
import com.example.vkapp.domain.common.Category
import com.example.vkapp.presentation.theme.RuStoreBlue

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
            AppListTopBar(
                onGridClick = { },
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 28.dp)
            )
        }
    ) { innerPadding ->
        AppList(
            items = appList,
            onAppClick = { onAppClick() }, // NOTE: Надо тут id, наверное, прокидывать, но пока так
            innerPadding = innerPadding,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding())
                .clip(
                    RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp
                    )
                )
                .background(color = colorScheme.surface)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AppListScreenPreview() {
    AppListScreen({})
}

// NOTE: В будущем заменим этот метод на вызов API.
private fun getAppList(): List<AppListItem> {
    return listOf(
        AppListItem(
            id = "1",
            name = "СберБанк Онлайн – с Салютом",
            iconUrl = "https://free-png.ru/wp-content/uploads/2020/09/icon_sber-01-370x370.png",
            shortDescription = "Больше чем банк",
            category = Category.FINANCE
        ),
        AppListItem(
            id = "2",
            name = "Яндекс.Браузер — с Алисой",
            iconUrl = "https://cdn.ruwiki.ru/commonswiki/files/thumb/8/84/Yandex.Browser_icon.svg/800px-Yandex.Browser_icon.svg.png",
            shortDescription = "Быстрый и безопасный браузер",
            category = Category.UTILITIES
        ),
        AppListItem(
            id = "3",
            name = "Почта Mail.ru",
            iconUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKgMBfD1oNsXwA3qfM1poC8ET5S292Jks7mg&s",
            shortDescription = "Почтовый клиент для любых ящиков",
            category = Category.UTILITIES
        ),
        AppListItem(
            id = "4",
            name = "Яндекс Навигатор",
            iconUrl = "https://download.logo.wine/logo/Yandex.Navigator/Yandex.Navigator-Logo.wine.png",
            shortDescription = "Парковки и заправки – по пути",
            category = Category.TRANSPORT
        ),
        AppListItem(
            id = "5",
            name = "Мой МТС",
            iconUrl = "https://open-store.io/icons/mts.vin4ter/mts.vin4ter-1.0.0.png",
            shortDescription = "Мой МТС — центр экосистемы МТС",
            category = Category.UTILITIES
        ),
        AppListItem(
            id = "6",
            name = "Яндекс — с Алисой",
            iconUrl = "https://cdn.aptoide.com/imgs/b/1/5/b159c355b0871c2f3e30c40331d25e5a_icon.png",
            shortDescription = "Яндекс — поиск всегда под рукой",
            category = Category.UTILITIES
        ),
        AppListItem(
            id = "7",
            name = "WildBerries",
            iconUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTK_NTOgWcZLXmTBnA4scv1uAvvaBP-ZO2MKQ&s",
            shortDescription = "Скидки каждый день",
            category = Category.MARKET
        ),
        AppListItem(
            id = "8",
            name = "VK Music",
            iconUrl = "https://cdn-yc-static.i-m-i.ru/store/uploads/profile/2358/photo/main-520d866638db75f4a4d3e430d7feef25.jpeg",
            shortDescription = "Музыка ВКонтакте без рекламы",
            category = Category.MUSIC
        ),
        AppListItem(
            id = "9",
            name = "VK Play",
            iconUrl = "https://corp.vkcdn.ru/media/images/VKP_ninja_1_CB6C23B.png",
            shortDescription = "Игры ВКонтакте без рекламы",
            category = Category.GAME
        ),
    )
}