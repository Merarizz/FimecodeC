package com.example.profime.core.estudiante

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { }
        //composable("home") { Mapa(navController) }
        composable("Maestro") { AdministradorMaestroScreen(navController) }
        composable("crearGrupo") { CreacionGrupo(navController) }
        composable("crearCurso") { CrearCursoScreen(navController) }
        composable("crearExamen") { CrearExamenConNavController(navController) }
        composable("notificaciones") { Notificaciones()}
        composable("estadisticas") { Estadisticas(navController) }
        composable("perfil") { MaestroProfile(navController) }
        composable("preguntaScreen/{tema}") { backStackEntry ->
            val tema = backStackEntry.arguments?.getString("tema") ?: ""
            PreguntaScreen(navController, tema)
        }
        }
    }
