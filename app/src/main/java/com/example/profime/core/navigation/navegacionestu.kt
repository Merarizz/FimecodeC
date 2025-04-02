package com.example.profime.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.profime.InicioSesion
import com.example.profime.core.estudiante.Estadisticas
import com.example.profime.core.estudiante.Inicio
import com.example.profime.core.estudiante.Notificaciones
import com.example.profime.core.estudiante.Perfil

@Composable
fun NavegacionEst(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Login.route){
        composable(Screens.Login.route){
            InicioSesion()
        }
        composable(Screens.InicioEstudiante.route) {
            Inicio()
        }
        composable(Screens.Notificaciones.route){
            Notificaciones()
        }
        composable(Screens.Perfil.route) {
            Perfil()
        }
        composable(Screens.Estadisticas.route){
            Estadisticas(navController)
        }
    }
}

