package com.example.mecanicaapp.data.datasource.local

import android.content.Context

class PreferencesHelper(
    context: Context
) {

    companion object {
        const val FIRST_INSTALL = "FIRST_INSTALL"
    }
    private val sharedPreferences = context.getSharedPreferences("mecanica_preferences", Context.MODE_PRIVATE)

    fun saveBoolean(value: Boolean) {
        sharedPreferences.edit().putBoolean(FIRST_INSTALL, value).apply()
    }

    fun getBoolean(): Boolean {
        return sharedPreferences.getBoolean(FIRST_INSTALL, false)
    }
}