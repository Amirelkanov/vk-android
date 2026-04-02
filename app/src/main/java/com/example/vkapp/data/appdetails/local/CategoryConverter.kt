package com.example.vkapp.data.appdetails.local

import androidx.room.TypeConverter
import com.example.vkapp.domain.Category

class CategoryConverter {
    @TypeConverter
    fun fromCategory(category: Category): String = category.name

    @TypeConverter
    fun toCategory(categoryName: String): Category = Category.valueOf(categoryName)
}