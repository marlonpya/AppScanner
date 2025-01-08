package com.example.mecanicaapp.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mecanicaapp.data.model.AutoPartTable


@Dao
interface AutoPartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: List<AutoPartTable>)

    @Query("Select * From autoPartTable Where code = :code")
    suspend fun get(code: String): AutoPartTable?

    @Query("SELECT * FROM autoPartTable")
    suspend fun getAllAutoParts(): List<AutoPartTable>

}