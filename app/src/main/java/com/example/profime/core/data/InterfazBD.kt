package com.example.profime.core.data

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.profime.core.common.Mensaje
import com.example.profime.core.navigation.Screens

@Composable
fun ValidaUsuario(navController: NavController, tipoUsuario: String, usuario: String, password: String){
    if (tipoUsuario == "Estudiantes"){
        navController.navigate(Screens.InicioEstudiante.route)
    }
    else {
        navController.navigate(Screens.Maestro.route)
    }
}
