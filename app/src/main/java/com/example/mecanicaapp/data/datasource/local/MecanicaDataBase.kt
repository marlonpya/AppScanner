package com.example.mecanicaapp.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mecanicaapp.data.datasource.local.dao.AutoPartDao
import com.example.mecanicaapp.data.model.AutoPartTable

@Database(version = 1, entities = [AutoPartTable::class], exportSchema = false)
abstract class MecanicaDataBase : RoomDatabase() {
    abstract fun getAutoPartDao() : AutoPartDao
}