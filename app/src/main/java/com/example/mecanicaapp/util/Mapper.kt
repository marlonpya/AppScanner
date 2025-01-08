package com.example.mecanicaapp.util

import com.example.mecanicaapp.data.model.AutoPartModel
import com.example.mecanicaapp.data.model.AutoPartTable

object Mapper {

    fun to(model: AutoPartModel) = AutoPartTable(
        model.id,
        model.code,
        model.codeMutec,
        model.description,
        model.priceBuy,
        model.priceSell,
        model.priceMerchant,
    )
    fun to(model: AutoPartTable) = AutoPartModel(
        model.id,
        model.code,
        model.codeMutec,
        model.description,
        model.priceBuy,
        model.priceSell,
        model.priceMerchant,
    )
}