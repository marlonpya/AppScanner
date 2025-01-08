package com.example.mecanicaapp.modules.search

import androidx.lifecycle.ViewModel
import com.example.mecanicaapp.data.model.AutoPartModel
import com.example.mecanicaapp.data.repository.local.MecanicaLocalRepositoryImpl

class SearchViewModel(
    private val repositoryImpl: MecanicaLocalRepositoryImpl
) : ViewModel() {

    companion object {
        val AUTO_PARTS = listOf(
            AutoPartModel(
                0,
                "D1543-8751",
                "PK47",
                "HYUNDAI ACCENT, RIO",
                "S/.60.94",
                "S/.93.76",
                "S/.150.00"
            ),
            AutoPartModel(
                0,
                "D1950-9175",
                "PT39",
                "TOYOTA YARIS ,ENVIDIA",
                "S/.49.35",
                "S/.75.93",
                "S/.150.00"
            ),
            AutoPartModel(
                0,
                "D696-7570",
                "PH20",
                "CHEVROLET N300, GEELY  CK D684",
                "S/.53.53",
                "S/.82.36",
                "S/.180.00"
            ),
        )
    }

    suspend fun saveData() {
        if (!repositoryImpl.getConfig()) {
            repositoryImpl.save(AUTO_PARTS)
            repositoryImpl.saveConfig()
        }
    }

}