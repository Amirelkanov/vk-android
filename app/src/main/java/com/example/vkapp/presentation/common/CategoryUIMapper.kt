package com.example.vkapp.presentation.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.vkapp.R
import com.example.vkapp.domain.common.Category

@Composable
fun Category.title(): String = when (this) {
    Category.APP -> stringResource(R.string.category_app)
    Category.GAME -> stringResource(R.string.category_game)
}
