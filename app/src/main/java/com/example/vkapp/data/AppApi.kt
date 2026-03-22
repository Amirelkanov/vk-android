package com.example.vkapp.data

import com.example.vkapp.data.appdetails.AppDetailsDto
import com.example.vkapp.data.applist.AppListItemDto
import com.example.vkapp.domain.Category
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

// Представим, что этот класс ходит в сеть.
class AppApi @Inject constructor() {
    suspend fun getAppDetails(): AppDetailsDto {
        // Эмулируем загрузку с бэкенда
        delay(2.seconds)
        val app = AppDetailsDto(
            name = "Гильдия Героев: Экшен ММО РПГ",
            developer = "VK Play",
            category = Category.APP,
            ageRating = 12,
            size = 223.7,
            screenshots = listOf(
                "https://static.rustore.ru/imgproxy/-y8kd-4B6MQ-1OKbAbnoAIMZAzvoMMG9dSiHMpFaTBc/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/dfd33017-e90d-4990-aa8c-6f159d546788.jpg@webp",
                "https://static.rustore.ru/imgproxy/dZCvNtRKKFpzOmGlTxLszUPmwi661IhXynYZGsJQvLw/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/60ec4cbc-dcf6-4e69-aa6f-cc2da7de1af6.jpg@webp",
                "https://static.rustore.ru/imgproxy/g5whSI1uNqaL2TUO7TFfM8M63vXpWXNCm2vlX4Ahvc4/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/c2dde8bc-c4ab-482a-80a5-2789149f598d.jpg@webp",
                "https://static.rustore.ru/imgproxy/TjeurtC7BczOVJt74XhjGYuQnG1l4rx6zpDqyMb00GY/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/08318f76-7a9c-43aa-b4a7-1aa878d00861.jpg@webp",
            ),
            icon = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
            description = "Легендарный рейд героев в Фэнтези РПГ. Станьте героем гильдии и зразите мастера подземелья!"
        )
        return app
    }

    suspend fun getAppList(): List<AppListItemDto> {
        delay(2.seconds)

        val appList = listOf(
            AppListItemDto(
                id = "1",
                name = "СберБанк Онлайн – с Салютом",
                iconUrl = "https://free-png.ru/wp-content/uploads/2020/09/icon_sber-01-370x370.png",
                shortDescription = "Больше чем банк",
                category = Category.FINANCE
            ),
            AppListItemDto(
                id = "2",
                name = "Яндекс.Браузер — с Алисой",
                iconUrl = "https://cdn.ruwiki.ru/commonswiki/files/thumb/8/84/Yandex.Browser_icon.svg/800px-Yandex.Browser_icon.svg.png",
                shortDescription = "Быстрый и безопасный браузер",
                category = Category.UTILITIES
            ),
            AppListItemDto(
                id = "3",
                name = "Почта Mail.ru",
                iconUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKgMBfD1oNsXwA3qfM1poC8ET5S292Jks7mg&s",
                shortDescription = "Почтовый клиент для любых ящиков",
                category = Category.UTILITIES
            ),
            AppListItemDto(
                id = "4",
                name = "Яндекс Навигатор",
                iconUrl = "https://download.logo.wine/logo/Yandex.Navigator/Yandex.Navigator-Logo.wine.png",
                shortDescription = "Парковки и заправки – по пути",
                category = Category.TRANSPORT
            ),
            AppListItemDto(
                id = "5",
                name = "Мой МТС",
                iconUrl = "https://open-store.io/icons/mts.vin4ter/mts.vin4ter-1.0.0.png",
                shortDescription = "Мой МТС — центр экосистемы МТС",
                category = Category.UTILITIES
            ),
            AppListItemDto(
                id = "6",
                name = "Яндекс — с Алисой",
                iconUrl = "https://cdn.aptoide.com/imgs/b/1/5/b159c355b0871c2f3e30c40331d25e5a_icon.png",
                shortDescription = "Яндекс — поиск всегда под рукой",
                category = Category.UTILITIES
            ),
            AppListItemDto(
                id = "7",
                name = "WildBerries",
                iconUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTK_NTOgWcZLXmTBnA4scv1uAvvaBP-ZO2MKQ&s",
                shortDescription = "Скидки каждый день",
                category = Category.MARKET
            ),
            AppListItemDto(
                id = "8",
                name = "VK Music",
                iconUrl = "https://cdn-yc-static.i-m-i.ru/store/uploads/profile/2358/photo/main-520d866638db75f4a4d3e430d7feef25.jpeg",
                shortDescription = "Музыка ВКонтакте без рекламы",
                category = Category.MUSIC
            ),
            AppListItemDto(
                id = "9",
                name = "VK Play",
                iconUrl = "https://corp.vkcdn.ru/media/images/VKP_ninja_1_CB6C23B.png",
                shortDescription = "Игры ВКонтакте без рекламы",
                category = Category.GAME
            ),
        )

        return appList
    }
}