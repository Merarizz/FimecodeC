package com.example.profime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.profime.core.estudiante.NavGraph
import com.example.profime.ui.theme.ProfimeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfimeTheme {
                // Crear el NavController
                val navController = rememberNavController()
                // Pasar el NavController a NavGraph
                NavGraph(navController = navController)
            }
        }
    }
}