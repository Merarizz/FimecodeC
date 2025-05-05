package com.example.profime.core.estudiante

sealed class Screens(val route: String) {
    object Administrador : Screens("administrador")
    object Perfil : Screens("perfil")
    object Grupos : Screens("grupos")
    object Cursos : Screens("cursos")
    object Estadisticas : Screens("estadisticas")
    object Notificaciones : Screens("notificaciones")
    object Mapa : Screens("mapa")
}