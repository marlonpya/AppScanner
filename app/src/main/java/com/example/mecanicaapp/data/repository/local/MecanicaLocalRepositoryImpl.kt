package com.example.mecanicaapp.data.repository.local

import com.example.mecanicaapp.data.datasource.local.PreferencesHelper
import com.example.mecanicaapp.data.datasource.local.dao.AutoPartDao
import com.example.mecanicaapp.data.model.AutoPartModel
import com.example.mecanicaapp.util.Mapper

class MecanicaLocalRepositoryImpl(
    private val dao : AutoPartDao,
    private val preferences: PreferencesHelper
): MecanicaLocalRepository {
    override suspend fun getAutoPart(code: String): AutoPartModel? {
        val model = dao.get(code)
        return if (model != null) {
            Mapper.to(model)
        } else null
    }

    override suspend fun save(autoPartList: List<AutoPartModel>) {
        dao.insert(autoPartList.map { Mapper.to(it) })
    }

    override fun saveConfig() {
        preferences.saveBoolean(true)
    }

    override fun getConfig(): Boolean {
        return preferences.getBoolean()
    }

    override suspend fun getAll(): List<AutoPartModel> {
        return dao.getAllAutoParts().map { Mapper.to(it) }
    }
}