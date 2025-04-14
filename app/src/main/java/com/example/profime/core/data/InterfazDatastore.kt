package com.example.profime.core.data

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.NavController
import kotlinx.coroutines.flow.map

val Context.preferenceDataStore: DataStore<Preferences> by preferencesDataStore(name = "datos_usuario")


data class Usuario(
    val nombre: String,
    val id: Int,
    val maestro: Boolean,
    val idcapitulo: Int
)

class DatastoreAdmin(val context: Context){
    companion object{
        val Nombre = stringPreferencesKey("nombre")
        val Id = stringPreferencesKey("id")
        val Maestro = stringPreferencesKey("maestro")
        val Idcapitulo = stringPreferencesKey("idcapitulo")
    }

    suspend fun saveData(usuario: Usuario){
        context.preferenceDataStore.edit{
            it[Nombre] = usuario.nombre
            it[Id] = usuario.id.toString()
            it[Maestro] = usuario.maestro.toString()
            it[Idcapitulo] = usuario.idcapitulo.toString()

        }
    }

    fun getData()  = context.preferenceDataStore.data.map {
        Usuario(
            nombre = it[Nombre] ?: "",
            id = it[Id]?.toInt() ?: 0,
            maestro = it[Maestro]?.toBoolean() ?: false,
            idcapitulo = it[Idcapitulo]?.toInt() ?: 0)
    }

    suspend fun clearData() = context.preferenceDataStore.edit{
        it.clear()
    }
}


@Composable
fun ValidaCapitulo(navController: NavController, capitulo: Int){


}