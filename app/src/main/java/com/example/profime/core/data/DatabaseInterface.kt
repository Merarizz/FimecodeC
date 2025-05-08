package com.example.profime.core.data

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import java.util.Locale.filter

@Serializable
data class Estudiante(
    val id_estudiante:Int,
    val nombre: String,
    val ap_paterno:String,
    val ap_materno:String,
    val matricula:Int,
    val carrera:String,
    val correo:String,
    val password:String,
    val examen_diagnostico:Int,
    val id_grupo:Int
)


val supabaseClient = createSupabaseClient(
    supabaseUrl = "https://dkgnczzjjuxsomjxtmdz.supabase.co",
    supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImRrZ25jenpqanV4c29tanh0bWR6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDM0NTcxNjEsImV4cCI6MjA1OTAzMzE2MX0.utPEpZ27tqfhzGNtF-M5JrGea4mLOtKLgS7LaamSrhY"
) {
    install(Postgrest)
}

@Composable
fun prueba1() {
    var lista by remember { mutableStateOf<List<Estudiante>>(emptyList()) }
    var ok by remember { mutableStateOf<Boolean?>(null) } // null = aún no se sabe

    var errorMsg by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            runCatching {
                supabaseClient.from("Estudiantes")
                    .select()
                    .decodeList<Estudiante>()
            }.onSuccess {
                lista = it
                ok = true
            }.onFailure { e ->
                ok = false
                errorMsg = e.localizedMessage ?: "Error"
            }
        }
    }
    when (ok) {
        null -> Text("Cargando...")
        true -> LazyColumn {
            items(lista, key = { it.id_estudiante }) { estudiante ->
                Text(estudiante.nombre, modifier = Modifier.padding(16.dp))
            }

        }
        false -> Column {
            Text("Error al cargar datos")
            errorMsg?.let { Text("Detalles: $it") }
        }
    }


}

@Composable
fun loginusuario(matricula:Int){
    var estudiante by remember { mutableStateOf<Estudiante?>(null) }
    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            runCatching {
                supabaseClient.from("Estudiantes")
                    .select(
                        columns = Columns.list("id", "nombre", "")
                ) {
                filter { Estudiante::matricula eq matricula }
            }.decodeSingleOrNull<Estudiante>()
            }.onSuccess {
                estudiante = it

            }.onFailure {
                estudiante = null
            }
        }
    }
}
