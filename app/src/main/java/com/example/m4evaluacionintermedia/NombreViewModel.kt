package com.example.m4evaluacionintermedia

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.m4evaluacionintermedia.DataBase.Nombre
import com.example.m4evaluacionintermedia.DataBase.NombreDao
import com.example.m4evaluacionintermedia.DataBase.NombreDataBase
import kotlinx.coroutines.launch

class NombreViewModel(application: Application): AndroidViewModel(application) {

    private val repository: NombreRepossitory
    val allNombre: LiveData<List<Nombre>>


    init {
        val NombreDao = NombreDataBase.getDataBase(application).getNombreDao()
        repository = NombreRepossitory(NombreDao)
        allNombre = repository.listAllNombre
    }
    fun insertNombre(nombre: Nombre) = viewModelScope.launch {
        repository.insertNombre(nombre)
    }

    fun deleteAllNombre() = viewModelScope.launch {
        repository.deleteAll()
    }

    fun getOneNombreByID(id : Int) : LiveData<Nombre> {
        return repository.getOneNombreByID(id)
    }

    fun updateNombre(mNombre: Nombre) = viewModelScope.launch {
        repository.updateNombre(mNombre)
    }

}