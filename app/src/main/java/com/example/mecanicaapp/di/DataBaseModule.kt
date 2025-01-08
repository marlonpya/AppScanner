package com.example.mecanicaapp.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.mecanicaapp.data.datasource.local.MecanicaDataBase
import com.example.mecanicaapp.data.datasource.local.PreferencesHelper
import com.example.mecanicaapp.data.datasource.local.dao.AutoPartDao
import com.example.mecanicaapp.data.repository.local.MecanicaLocalRepositoryImpl
import com.example.mecanicaapp.di.DataBaseModule.provideDao
import com.example.mecanicaapp.di.DataBaseModule.provideDatabase
import com.example.mecanicaapp.di.DataBaseModule.providePreferencesHelper

object DataBaseModule {

    fun provideDatabase(context: Context): MecanicaDataBase {
        return Room.databaseBuilder(
            context,
            MecanicaDataBase::class.java,
            "mecanica.db"
        ).build()
    }

    fun provideDao(database: MecanicaDataBase): AutoPartDao =
        database.getAutoPartDao()


    fun providePreferencesHelper(context: Context): PreferencesHelper = PreferencesHelper(context)
}

fun provideLocalRepo(
    context: Context,
): MecanicaLocalRepositoryImpl =
    MecanicaLocalRepositoryImpl(
        provideDao(provideDatabase(context)),
        providePreferencesHelper(context)
    )

fun <VM: ViewModel> myViewModelFactory(initializer: ()-> VM): ViewModelProvider.Factory {
    return object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return initializer() as T
        }
    }
}