package com.example.vkapp.presentation.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkapp.domain.applist.AppListItem
import com.example.vkapp.domain.common.Category
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class AppListViewModel : ViewModel() {
    private val _state = MutableStateFlow<AppListState>(AppListState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<AppListEvent>(BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        getAppList()
    }

    fun showAppTitleMessage(app: AppListItem) {
        viewModelScope.launch {
            _events.send(AppListEvent.ShowAppTitle(app.name))
        }
    }

    fun getAppList() {
        viewModelScope.launch {
            _state.value = AppListState.Loading

            runCatching {
                // Эмулируем загрузку с бэкенда
                delay(2.seconds)

                // В будущем заменим этот метод на вызов API
                val appList = listOf(
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

                _state.value = AppListState.Content(appList)
            }.onFailure {
                _state.value = AppListState.Error
            }
        }
    }
}