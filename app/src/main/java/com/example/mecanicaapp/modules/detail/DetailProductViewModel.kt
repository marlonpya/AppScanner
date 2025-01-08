package com.example.mecanicaapp.modules.detail

import androidx.lifecycle.ViewModel
import com.example.mecanicaapp.data.repository.local.MecanicaLocalRepositoryImpl

class DetailProductViewModel(
    private val repositoryImpl: MecanicaLocalRepositoryImpl
): ViewModel() {

    suspend fun getAutoPart(code: String) = repositoryImpl.getAutoPart(code)
}