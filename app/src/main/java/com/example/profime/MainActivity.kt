package com.example.profime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.profime.core.estudiante.BarraSuperior
import com.example.profime.core.estudiante.Estadisticas
import com.example.profime.core.estudiante.Inicio
import com.example.profime.core.estudiante.Mapa
import com.example.profime.core.estudiante.Notificaciones
import com.example.profime.core.estudiante.Perfil
//import com.example.profime.core.estudiante.Qr
import com.example.profime.ui.theme.ProfimeTheme

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
        Mapa()
    }
}
