package com.example.profime.core.estudiante

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.profime.R
import com.example.profime.core.data.Estudiante

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { Login(navController) }

        composable("home") {
            //val estudiante = Estudiante("Salvador Guzman", "10897", "Grupo 4203", "juan.perez@fime.com", R.drawable.logo_estudiante)
            //InicioEstudianteScreen(navController, estudiante)
        }

        composable("qrScanner") {
            // Esto asegura que QrScanner está en un contexto composable
            QrScanner(navController = navController)
        }

        composable("mapa") { Mapa(navController) }
        composable("Maestro") { AdministradorMaestroScreen(navController) }
        composable("crearGrupo") { CreacionGrupo(navController) }
        composable("crearCurso") { CrearCursoScreen(navController) }
        composable("crearExamen") { CrearExamenConNavController(navController) }
        composable("notificaciones") { Notificaciones(navController) }
        composable("estadisticas") { Estadisticas(navController) }

        composable("perfil") { MaestroProfile(navController) }
        composable("registro") { Registro(navController) }
        composable("preguntaScreen/{tema}") { backStackEntry ->
            val tema = backStackEntry.arguments?.getString("tema") ?: ""
            PreguntaScreen(navController, tema)
        }
    }
}