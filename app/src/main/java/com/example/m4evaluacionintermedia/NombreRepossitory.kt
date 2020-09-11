package com.example.m4evaluacionintermedia

import androidx.lifecycle.LiveData
import com.example.m4evaluacionintermedia.DataBase.Nombre
import com.example.m4evaluacionintermedia.DataBase.NombreDao

class NombreRepossitory(private val mNombreDao: NombreDao) {

    val listAllNombre : LiveData<List<Nombre>> = mNombreDao.getAllNombreFromDb()

    suspend fun insertNombre(mNombre: Nombre) {
        mNombreDao.insertOneNombre(mNombre)
    }

    suspend fun  deleteAll() {
        mNombreDao.deleteAllNombres()
    }

    fun getOneNombreByID(id : Int) : LiveData<Nombre> {
        return mNombreDao.getOneNombreByID()
    }

    suspend fun updateNombre(mNombre: Nombre) {
        mNombreDao.updateOneNombre(mNombre)
    }
}