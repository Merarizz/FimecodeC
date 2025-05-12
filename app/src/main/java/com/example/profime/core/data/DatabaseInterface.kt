package com.example.profime.core.data

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.profime.core.common.Mensaje
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable


@Serializable
data class Estudiante(
    val id_estudiante: Int,
    val nombre: String,
    val ap_paterno: String,
    val ap_materno: String,
    val matricula: Int,
    val carrera: String,
    val correo: String,
    val password: String,
    val examen_diagnostico: Int,
    val id_grupo: Int
)
val supabaseClient = createSupabaseClient(
    supabaseUrl = "https://dkgnczzjjuxsomjxtmdz.supabase.co",
    supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImRrZ25jenpqanV4c29tanh0bWR6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDM0NTcxNjEsImV4cCI6MjA1OTAzMzE2MX0.utPEpZ27tqfhzGNtF-M5JrGea4mLOtKLgS7LaamSrhY"
) {
    install(Postgrest)
}


@Composable
fun ValidaLoginEstudiante(matricula: String, password: String): Boolean {
    var user by remember { mutableStateOf<Estudiante?>(null) }
        if (matricula== "" || password == ""){
        Mensaje("Por favor ingrese su matricula y contraseña")
        return false
    }
    var imatricula = matricula.toInt()
    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            runCatching {
                supabaseClient.from("Estudiantes")
                    .select(columns = Columns.list("id_estudiante", "nombre", "ap_paterno",
                        "ap_materno", "matricula", "carrera", "correo", "password", "examen_diagnostico", "id_grupo"))
                    {
                        filter {  Estudiante::matricula eq 1876457 }
                    }
                    .decodeSingleOrNull<Estudiante>()
            }
                .onSuccess {
                    user=it
                }
                .onFailure {
                    user=null
                }
        }
    }
    if (user != null) {
        if (user!!.password == password) {
            return true
            //return user!!
        } else {
            Mensaje("Contraseña incorrecta")
            return false
        }
    }
    else{
        Mensaje("Usuario no encontrado")
        return false
    }
}
