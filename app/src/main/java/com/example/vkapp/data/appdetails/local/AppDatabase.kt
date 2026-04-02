package com.example.vkapp.data.appdetails.local

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [AppDetailsEntity::class],
    version = 2,
    autoMigrations = [
        // Знаю, что обычно ручками запросы пишут и мигрируют,
        // но давайте для добавления колонку отдадим дело автоматизации
        AutoMigration(from = 1, to = 2)
    ]
)
@TypeConverters(CategoryConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDetailsDao(): AppDetailsDao

    companion object {
        const val DATABASE_NAME = "app_database"
    }

}