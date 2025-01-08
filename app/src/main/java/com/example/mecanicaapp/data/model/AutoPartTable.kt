package com.example.mecanicaapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "autoPartTable")
data class AutoPartTable(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val code: String,
    val codeMutec: String,
    val description: String,
    val priceBuy: String,
    val priceSell: String,
    val priceMerchant: String,
)