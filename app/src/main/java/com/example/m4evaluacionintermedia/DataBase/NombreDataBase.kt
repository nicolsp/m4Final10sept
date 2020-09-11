package com.example.m4evaluacionintermedia.DataBase

import  android.content.Context
import androidx.room.Room
import androidx.room.Database
import androidx.room.RoomDatabase

private const val DATA_BASE_NAME = "nombre_db"

@Database(entities = [Nombre::class], version = 1)
abstract class NombreDataBase : RoomDatabase() {

    abstract fun getNombreDao(): NombreDao

    companion object {
        @Volatile
        private var INSTANCE: NombreDataBase? = null

        fun getDataBase(context: Context): NombreDataBase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return  tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context,
                NombreDataBase::class.java, DATA_BASE_NAME
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
