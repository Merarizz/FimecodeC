package com.example.profime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profime.core.estudiante.BarraSuperior
import com.example.profime.core.estudiante.Estadisticas
import com.example.profime.core.estudiante.Inicio
import com.example.profime.core.estudiante.Mapa
import com.example.profime.core.estudiante.Notificaciones
import com.example.profime.core.estudiante.Perfil
//import com.example.profime.core.estudiante.Qr
import com.example.profime.ui.theme.ProfimeTheme
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@Composable
fun App(){
    ProfimeTheme {
       Notificaciones()
    }
}
@Composable
fun scaner (){
    var resultadoEscaner by remember { mutableStateOf("") }
    val scanLauncher = rememberLauncherForActivityResult(
        contract = ScanContract(),
        onResult = { result ->
            resultadoEscaner = result.contents?: "No hay resultado"
        }
    )
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment =  Alignment.CenterHorizontally
    ){
        Text(text = "Resultado: ${resultadoEscaner}")
        Button(
            onClick = {
                val scanOptions = ScanOptions()
                scanOptions.setBeepEnabled(true)
                scanLauncher.launch(scanOptions)
            }){
            Text("Escaner")
        }
    }
}
