package com.example.profime.core.navigation

import com.example.profime.core.estudiante.AdministradorMaestroScreen
import com.example.profime.core.estudiante.CreacionGrupo
import com.example.profime.core.estudiante.CrearCursoScreen
import com.example.profime.core.estudiante.CrearExamenConNavController
import com.example.profime.core.estudiante.Estadisticas
import com.example.profime.core.estudiante.MaestroProfile
import com.example.profime.core.estudiante.Notificaciones
import com.example.profime.core.estudiante.PreguntaScreen

sealed class Screens(val route: String) {
    object Login : Screens("login")
    object InicioEstudiante : Screens("inicioEstudiante")
    object Perfil : Screens("perfil")
    object Estadisticas : Screens("estadisticas")
    object Notificaciones : Screens("notificaciones")
    object Mapa : Screens("mapa")

    object Maestro : Screens("Maestro")
    object crearGrupo : Screens("crearGrupo")
    object crearCurso : Screens("crearCurso")
    object crearExamen : Screens("crearExamen")
    object perfilmaestro : Screens("perfilmaestro")
    object preguntaScreen : Screens("preguntaScreen/{tema}")
}
