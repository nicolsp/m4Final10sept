package com.example.m4evaluacionintermedia.DataBase

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_nombres")
data class Nombre(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Int = 0,
    val nombre: String,
    val completeNombre: Boolean,
    val cantidad: Int =0,
    val precio: Double = 0.0


) {
}