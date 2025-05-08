package com.example.profime.core.estudiante

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.profime.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController) {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var selectedRole by remember { mutableStateOf("Estudiante") }

    val roles = listOf("Estudiante", "Maestro")

    // Logo inicial antes de seleccionar el rol
    val initialLogo = R.drawable.uanllogo  // Asegúrate de tener un logo inicial para esta fase

    // Definir imágenes según el rol
    val roleImage = if (selectedRole == "Estudiante") R.drawable.logo_estudiante else R.drawable.maestro_logo

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFF1E88E5), Color(0xFF64B5F6))))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Mostrar el logo inicial antes de seleccionar el rol
            AnimatedContent(targetState = selectedRole) { state ->
                if (state == "Estudiante" || state == "Maestro") {
                    Image(
                        painter = painterResource(id = roleImage),
                        contentDescription = "Imagen de rol",
                        modifier = Modifier
                            .size(150.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.3f))
                            .padding(16.dp)
                            .shadow(10.dp, shape = CircleShape), // Sombra para dar más profundidad
                        contentScale = ContentScale.Crop
                    )
                } else {
                    // Muestra el logo inicial cuando no se ha seleccionado un rol
                    Image(
                        painter = painterResource(id = initialLogo),
                        contentDescription = "Logo inicial",
                        modifier = Modifier
                            .size(150.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.3f))
                            .padding(16.dp)
                            .shadow(10.dp, shape = CircleShape), // Sombra para dar más profundidad
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Bienvenido",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Inicia sesión para continuar",
                fontSize = 16.sp,
                color = Color.White.copy(alpha = 0.8f)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // INPUT DE USUARIO
            OutlinedTextField(
                value = user,
                onValueChange = { user = it },
                label = { Text("Matrícula") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.Transparent,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.Gray,
                    cursorColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // INPUT DE CONTRASEÑA
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Contraseña") },
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = "Mostrar/ocultar contraseña"
                        )
                    }
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.Transparent,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.Gray,
                    cursorColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // OPCIÓN OLVIDAR CONTRASEÑA
            Text(
                text = "¿Olvidaste tu contraseña?",
                color = Color.White.copy(alpha = 0.9f),
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable { /* Implementar recuperación de contraseña */ }
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // SELECCIÓN DE ROL
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                roles.forEach { role ->
                    Button(
                        onClick = { selectedRole = role },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (selectedRole == role) Color(0xFF1565C0) else Color(0xFF90CAF9),
                            contentColor = if (selectedRole == role) Color.White else Color.Black
                        ),
                        shape = RoundedCornerShape(25.dp),
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .weight(1f)
                    ) {
                        Text(text = role, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // BOTÓN DE INICIAR SESIÓN
            //creardatastore
            Button(
                onClick = {
                    if (selectedRole == "Estudiante") {
                        //funcion en databaseinterface
                        navController.navigate("home")
                    } else {
                        navController.navigate("Maestro")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E88E5)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Iniciar Sesión", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // PRIMERA VEZ AQUÍ
            Text(
                text = "¿Primera vez aquí? Regístrate",
                color = Color.White.copy(alpha = 0.9f),
                modifier = Modifier.clickable {
                    navController.navigate("registro")
                }
            )
        }
    }
}