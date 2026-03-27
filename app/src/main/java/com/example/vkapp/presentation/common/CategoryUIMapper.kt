package com.example.vkapp.presentation.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.vkapp.R
import com.example.vkapp.domain.Category

@Composable
fun Category.title(): String = when (this) {
    Category.APP -> stringResource(R.string.category_app)
    Category.GAME -> stringResource(R.string.category_game)
    Category.PRODUCTIVITY -> stringResource(R.string.category_productivity)
    Category.SOCIAL -> stringResource(R.string.category_social)
    Category.EDUCATION -> stringResource(R.string.category_education)
    Category.ENTERTAINMENT -> stringResource(R.string.category_entertainment)
    Category.MUSIC -> stringResource(R.string.category_music)
    Category.VIDEO -> stringResource(R.string.category_video)
    Category.PHOTOGRAPHY -> stringResource(R.string.category_photography)
    Category.HEALTH -> stringResource(R.string.category_health)
    Category.SPORTS -> stringResource(R.string.category_sports)
    Category.NEWS -> stringResource(R.string.category_news)
    Category.BOOKS -> stringResource(R.string.category_books)
    Category.BUSINESS -> stringResource(R.string.category_business)
    Category.FINANCE -> stringResource(R.string.category_finance)
    Category.TRAVEL -> stringResource(R.string.category_travel)
    Category.MAPS -> stringResource(R.string.category_maps)
    Category.FOOD -> stringResource(R.string.category_food)
    Category.SHOPPING -> stringResource(R.string.category_shopping)
    Category.UTILITIES -> stringResource(R.string.category_utilities)
    Category.TRANSPORT -> stringResource(R.string.category_transport)
    Category.NAVIGATION -> stringResource(R.string.category_navigation)
    Category.COMMUNICATION -> stringResource(R.string.category_communication)
    Category.WEATHER -> stringResource(R.string.category_weather)
}