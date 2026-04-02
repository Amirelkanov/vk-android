package com.example.vkapp.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Category {
    @SerialName("Приложения")
    APP,

    @SerialName("Игры")
    GAME,

    @SerialName("Производительность")
    PRODUCTIVITY,

    @SerialName("Социальные сети")
    SOCIAL,

    @SerialName("Образование")
    EDUCATION,

    @SerialName("Развлечения")
    ENTERTAINMENT,

    @SerialName("Музыка")
    MUSIC,

    @SerialName("Видео")
    VIDEO,

    @SerialName("Фото и видео")
    PHOTOGRAPHY,

    @SerialName("Здоровье и фитнес")
    HEALTH,

    @SerialName("Образ жизни")
    SPORTS,

    @SerialName("Новости")
    NEWS,

    @SerialName("Книги и справочники")
    BOOKS,

    @SerialName("Бизнес")
    BUSINESS,

    @SerialName("Финансы")
    FINANCE,

    @SerialName("Путешествия")
    TRAVEL,

    @SerialName("Карты")
    MAPS,

    @SerialName("Еда и напитки")
    FOOD,

    @SerialName("Шопинг")
    SHOPPING,

    @SerialName("Утилиты")
    UTILITIES,

    @SerialName("Транспорт")
    TRANSPORT,

    @SerialName("Навигация")
    NAVIGATION,

    @SerialName("Общение")
    COMMUNICATION,

    @SerialName("Погода")
    WEATHER
}