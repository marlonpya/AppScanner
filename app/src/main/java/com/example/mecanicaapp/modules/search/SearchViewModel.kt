package com.example.mecanicaapp.modules.search

import androidx.lifecycle.ViewModel
import com.example.mecanicaapp.data.repository.local.MecanicaLocalRepositoryImpl
import com.example.mecanicaapp.util.DataLocal

class SearchViewModel(
    private val repositoryImpl: MecanicaLocalRepositoryImpl
) : ViewModel() {

    suspend fun saveData() {
        if (!repositoryImpl.getConfig()) {
            repositoryImpl.save(DataLocal.AUTO_PARTS)
            repositoryImpl.saveConfig()
        }
    }

}