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
import com.example.profime.core.common.Mensaje
import com.example.profime.core.data.ValidaLoginEstudiante
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController) {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var selectedRole by remember { mutableStateOf("Estudiante") }
    var iniciosesion by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()

    val roles = listOf("Estudiante", "Maestro")

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
            Image(
                painter = painterResource(id = roleImage),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.3f))
                    .padding(16.dp)
                    .shadow(10.dp, shape = CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text("Bienvenido", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Inicia sesión para continuar", color = Color.White.copy(alpha = 0.8f))

            Spacer(modifier = Modifier.height(32.dp))

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

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Contraseña") },
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

            Text("¿Olvidaste tu contraseña?", color = Color.White.copy(alpha = 0.9f),
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable { /* recuperación */ }
                    .padding(8.dp))

            Spacer(modifier = Modifier.height(24.dp))

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
                        Text(role, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    iniciosesion = true
                    //scope.launch {
                    //}
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

            Text("¿Primera vez aquí? Regístrate", color = Color.White.copy(alpha = 0.9f),
                modifier = Modifier.clickable {
                    navController.navigate("registro")
                })

            if (iniciosesion) {
                if (selectedRole == "Estudiante") {
                    if(ValidaLoginEstudiante(user, password))
                        navController.navigate("home")
                } else {
                    navController.navigate("Maestro")
                }
                iniciosesion = false
            }
        }
    }
}
