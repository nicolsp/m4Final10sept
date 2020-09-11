package com.example.m4evaluacionintermedia.DataBase

import androidx.lifecycle.LiveData
import androidx.room.*

interface NombreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOneNombre(mNombre: Nombre)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMultipleNombre(mNombre: List<Nombre>)

    @Update
    suspend fun updateOneNombre(mNombre: Nombre)

    @Delete
    fun deleteOneNombre(mNombre: Nombre)

    @Query("SELECT * FROM table_nombres")
    fun  getAllNombreFromDb(): LiveData<List<Nombre>>

    @Query("SELECT * FROM TABLE_NOMBRES WHERE id =:mId")
    fun getOneNombreByID(mId: Int): LiveData<Nombre>

    @Query("DELETE FROM table_nombres")
    suspend fun deleteAllNombres()





}