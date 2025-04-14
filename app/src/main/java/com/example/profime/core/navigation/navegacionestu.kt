package com.example.profime.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.profime.InicioSesion
import com.example.profime.core.estudiante.AdministradorMaestroScreen
import com.example.profime.core.estudiante.CreacionGrupo
import com.example.profime.core.estudiante.CrearCursoScreen
import com.example.profime.core.estudiante.CrearExamenConNavController
import com.example.profime.core.estudiante.Estadisticas
import com.example.profime.core.estudiante.Inicio
import com.example.profime.core.estudiante.MaestroProfile
import com.example.profime.core.estudiante.Mapa
import com.example.profime.core.estudiante.Notificaciones
import com.example.profime.core.estudiante.Perfil
import com.example.profime.core.estudiante.PreguntaScreen

@Composable
fun NavegacionEst(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Login.route){
        composable(Screens.Login.route){
            InicioSesion(navController)
        }
        composable(Screens.InicioEstudiante.route) {
            Inicio(navController)
        }
        composable(Screens.Notificaciones.route){
            Notificaciones(navController)
        }
        composable(Screens.Perfil.route) {
            Perfil(navController)
        }
        composable(Screens.Estadisticas.route){
            Estadisticas(navController)
        }
        composable(Screens.Mapa.route){
            Mapa(navController)
        }
        composable(Screens.Maestro.route) {
            AdministradorMaestroScreen(navController)
        }

        composable(Screens.crearGrupo.route) {
            CreacionGrupo(navController)
        }

        composable(Screens.crearCurso.route) {
            CrearCursoScreen(navController)
        }

        composable(Screens.crearExamen.route) {
            CrearExamenConNavController(navController)
        }

        composable(Screens.perfilmaestro.route) {
            MaestroProfile(navController)
        }

        composable(Screens.preguntaScreen.route) {
            backStackEntry ->
            val tema = backStackEntry.arguments?.getString("tema") ?: ""
            PreguntaScreen(navController, tema)
        }
    }
}



