package com.example.profime.core.estudiante

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.profime.R

@Composable
fun MaestroProfile(navController: NavController) {
    Scaffold(
        topBar = { BarraSuperior() }, // Barra superior
        bottomBar = { BarraInferior() }, // Barra inferior
        content = { paddingValues ->
            ContentMaestroProfile(navController, paddingValues)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ContentMaestroProfile(navController: NavController, paddingValues: PaddingValues) {
    var maestroName by remember { mutableStateOf("Juan Pérez") }
    var maestroEmail by remember { mutableStateOf("juan.perez@profime.com") }
    var maestroRole by remember { mutableStateOf("Maestro") }

    // Variables de estado para la edición
    var isEditingName by remember { mutableStateOf(false) }
    var isEditingEmail by remember { mutableStateOf(false) }
    var isEditingRole by remember { mutableStateOf(false) }

    // Imagen de perfil
    val profileImage = R.drawable.osomaestro

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Fondo blanco
            .padding(bottom = 80.dp) // Espacio para evitar que el contenido se oculte bajo el menú inferior
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagen de perfil
            Box(
                modifier = Modifier
                    .size(130.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color(0xFF1976D2), CircleShape)
                    .background(Color.Gray.copy(alpha = 0.1f))
                    .clickable {
                        // Acción para cambiar la imagen
                    }
            ) {
                Image(
                    painter = painterResource(id = profileImage),
                    contentDescription = "Imagen de perfil del maestro",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Mostrar nombre y permitir edición al hacer clic en el lápiz
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (isEditingName) {
                    // Campo editable para el nombre del maestro
                    OutlinedTextField(
                        value = maestroName,
                        onValueChange = { maestroName = it },
                        label = { Text("Nombre") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFF1976D2),
                            unfocusedBorderColor = Color.Gray
                        )
                    )
                } else {
                    Text(
                        text = maestroName,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(
                        onClick = { isEditingName = true }
                    ) {
                        Icon(painter = painterResource(id = R.drawable.editar), contentDescription = "Editar Nombre")
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Mostrar correo y permitir edición al hacer clic en el lápiz
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (isEditingEmail) {
                    // Campo editable para el correo del maestro
                    OutlinedTextField(
                        value = maestroEmail,
                        onValueChange = { maestroEmail = it },
                        label = { Text("Correo Electrónico") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFF1976D2),
                            unfocusedBorderColor = Color.Gray
                        )
                    )
                } else {
                    Text(
                        text = maestroEmail,
                        fontSize = 16.sp,
                        color = Color.Black.copy(alpha = 0.7f),
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(
                        onClick = { isEditingEmail = true }
                    ) {
                        Icon(painter = painterResource(id = R.drawable.editar), contentDescription = "Editar Correo")
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Mostrar rol y permitir edición al hacer clic en el lápiz
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (isEditingRole) {
                    // Campo editable para el rol del maestro
                    OutlinedTextField(
                        value = maestroRole,
                        onValueChange = { maestroRole = it },
                        label = { Text("Rol") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFF1976D2),
                            unfocusedBorderColor = Color.Gray
                        )
                    )
                } else {
                    Text(
                        text = maestroRole,
                        fontSize = 16.sp,
                        color = Color.Black.copy(alpha = 0.7f),
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(
                        onClick = { isEditingRole = true }
                    ) {
                        Icon(painter = painterResource(id = R.drawable.editar), contentDescription = "Editar Rol")
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Botón de guardar cambios
            Button(
                onClick = {
                    // Guardar cambios aquí (por ejemplo, en un ViewModel o base de datos)
                    Log.d("MaestroProfile", "Cambios guardados: Nombre: $maestroName, Correo: $maestroEmail, Rol: $maestroRole")
                    // Cerrar la edición después de guardar
                    isEditingName = false
                    isEditingEmail = false
                    isEditingRole = false
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Guardar Cambios", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón de cerrar sesión
            Button(
                onClick = {
                    // Acción para cerrar sesión
                    navController.navigate("login") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB71C1C)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Cerrar Sesión", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}