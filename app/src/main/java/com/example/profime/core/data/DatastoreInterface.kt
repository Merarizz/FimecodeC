package com.example.profime.core.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.preferencesDataStore
import java.util.prefs.Preferences

val Context.preferencesDataStore: DataStore<Preferences> by preferencesDataStore(name = "datos_usuario")


data class Estudiante(
    val nombre: String,
    val numero: String,
    val grupo: String,
    val correo: String,
    val fotoPerfil: Int , // Agregamos la propiedad fotoPerfil
    val idcapitulo: Int // Agregamos la propiedad idcapitulo
)