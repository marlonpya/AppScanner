package com.example.mecanicaapp.data.repository.local

import com.example.mecanicaapp.data.model.AutoPartModel

interface MecanicaLocalRepository {

    suspend fun getAutoPart(code: String): AutoPartModel?
    suspend fun save(autoPartList: List<AutoPartModel>)
    fun saveConfig()
    fun getConfig() : Boolean
    suspend fun getAll(): List<AutoPartModel>
}