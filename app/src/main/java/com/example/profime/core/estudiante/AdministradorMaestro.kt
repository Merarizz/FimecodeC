package com.example.profime.core.estudiante

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.ListAlt
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

import com.example.profime.R


@Composable
fun AdministradorMaestroScreen(navController: NavController) {
    Scaffold(
        topBar = { BarraSuperior() },
        bottomBar = { BarraInferior(navController) }
    ) { paddingValues ->
        ContentAdministradorMaestro(navController, paddingValues)
    }
}
@Composable
fun PerfilUsuario() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.osomaestro), // Usa una imagen válida en tu proyecto
            contentDescription = "Foto de perfil",
            modifier = Modifier.size(80.dp).clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("Arturo Amador", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text("Maestro Administrador ", fontWeight = FontWeight.Bold, fontSize = 12.sp)
    }
}
@Composable
fun ContentAdministradorMaestro(navController: NavController, paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp)
    ) {
        // Imagen de perfil y nombre del usuario
        PerfilUsuario()

        // Menú con pestañas modernas
        TabsAdministrador(navController)
    }
}

@Composable
fun TabsAdministrador(navController: NavController) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Grupos", "Cursos", "Estadísticas", "Exámenes")
    val icons = listOf(
        Icons.Default.Group,
        Icons.Default.Book,
        Icons.Default.BarChart,
        Icons.Default.ListAlt
    )

    Column {
        // Botones de navegación estilo Material 3
        ScrollableTabRow(
            selectedTabIndex = selectedTab,
            edgePadding = 0.dp,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier
                        .tabIndicatorOffset(tabPositions[selectedTab])
                        .background(MaterialTheme.colorScheme.primary)
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) },
                    icon = { Icon(imageVector = icons[index], contentDescription = title) }
                )
            }
        }

        // Contenido dinámico según la pestaña seleccionada
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            when (selectedTab) {
                0 -> ContentGrupos(navController)
                1 -> CrearCursoScreen(navController)  // Esto es correcto
                2 -> ContentEstadisticas()
                3 -> ContentExamenes(navController)
            }
            }
        }
    }

@Composable
fun ContentGrupos(navController: NavController) {
    // Lista de grupos simulada
    val grupos = listOf("Grupo A", "Grupo B", "Grupo C", "Grupo D")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Grupos Disponibles",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Mostrar los grupos
        grupos.forEach { grupo ->
            SeccionGrupo(grupo)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para crear nuevo grupo que navega a CreacionGrupo
        Button(onClick = { navController.navigate("crearGrupo") }) {
            Text("Crear nuevo grupo")
        }
    }
}

@Composable
fun SeccionGrupo(grupo: String) {
    Button(onClick = { /* Acción de ver detalles del grupo */ }, modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Text(text = grupo)
    }
}
@Composable
fun CrearCursoScreen(navController: NavController) {
    // Lista de cursos simulada
    val cursos = listOf(
        "Curso de Kotlin para Android",
        "Introducción a la Programación en Java",
        "Fundamentos de la Inteligencia Artificial"
    )
    var showDialog by remember { mutableStateOf(false) }
    var selectedCurso by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        Text(
            text = "Cursos Disponibles",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        cursos.forEach { curso ->
            SeccionCurso(curso, onClick = { selectedCurso = curso }, navController)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para crear nuevo curso
        Button(onClick = { navController.navigate("crearCurso") }) {
            Text("Crear nuevo curso")
        }

        // Cuadro de diálogo para ver detalles de un curso
        if (selectedCurso != null) {
            AlertDialog(
                onDismissRequest = { selectedCurso = null },
                title = { Text("Detalles del Curso: $selectedCurso") },
                text = {
                    Text("Aquí puedes mostrar más detalles sobre el curso $selectedCurso.")
                },
                confirmButton = {
                    Button(onClick = { selectedCurso = null }) {
                        Text("Aceptar")
                    }
                },
                dismissButton = {
                    Button(onClick = { selectedCurso = null }) {
                        Text("Cerrar")
                    }
                }
            )
        }

        // Aquí puedes agregar un Dialog o un formulario para crear el curso
        if (showDialog) {
            // Aquí iría un cuadro de diálogo para agregar un curso
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Nuevo Curso") },
                text = {
                    Text("Aquí puedes agregar el formulario para crear un nuevo curso.")
                },
                confirmButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("Aceptar")
                    }
                },
                dismissButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("Cancelar")
                    }
                }
            )
        }
    }
}

@Composable
fun SeccionCurso(curso: String, onClick: () -> Unit, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }, // Llama al callback cuando se hace clic
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Book,
                    contentDescription = curso,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = curso,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón para acceder a los quizzes del curso
            Button(onClick = { navController.navigate("preguntaScreen/ALU") }) {
                Text("Ver preguntas sobre ALU")
            }
        }
    }
}
@Composable
fun ContentEstadisticas() {
    // Datos de estadísticas simulados
    val totalEstudiantes = 50
    val estudiantesAprobados = 40
    val estudiantesReprobados = 10

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Estadísticas del Curso",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text("Total de estudiantes: $totalEstudiantes")
        Text("Estudiantes aprobados: $estudiantesAprobados")
        Text("Estudiantes reprobados: $estudiantesReprobados")

        Spacer(modifier = Modifier.height(16.dp))

        // Aquí podrías agregar un gráfico, pero para este ejemplo solo mostramos texto.
        Text("Aquí podría ir un gráfico de barras de rendimiento", color = Color.Gray)
    }
}

@Composable
fun ContentExamenes(navController: NavController) {
    var examenes by remember { mutableStateOf(listOf("Examen de Kotlin", "Examen de Java")) }
    var showDialog by remember { mutableStateOf(false) }
    var selectedExamen by remember { mutableStateOf<String?>(null) }
    var newExamenName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Exámenes Disponibles",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        examenes.forEach { examen ->
            SeccionExamen(examen, onClick = { selectedExamen = examen })
        }

        Spacer(modifier = Modifier.height(16.dp))


        Button(onClick = { navController.navigate("crearExamen") }) {
            Text("Crear nuevo examen")
        }
        // Cuadro de diálogo para ver detalles de un examen
        if (selectedExamen != null) {
            AlertDialog(
                onDismissRequest = { selectedExamen = null },
                title = { Text("Detalles del Examen: $selectedExamen") },
                text = { Text("Aquí puedes mostrar más detalles sobre el examen $selectedExamen.") },
                confirmButton = {
                    Button(onClick = { selectedExamen = null }) { Text("Aceptar") }
                },
                dismissButton = {
                    Button(onClick = { selectedExamen = null }) { Text("Cerrar") }
                }
            )
        }

        // Cuadro de diálogo para agregar un nuevo examen
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Nuevo Examen") },
                text = {
                    Column {
                        OutlinedTextField(
                            value = newExamenName,
                            onValueChange = { newExamenName = it },
                            label = { Text("Nombre del Examen") },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                },
                confirmButton = {
                    Button(onClick = {
                        if (newExamenName.isNotBlank()) {
                            examenes = examenes + newExamenName // Agregar a la lista
                            newExamenName = ""
                            showDialog = false
                        }
                    }) {
                        Text("Agregar")
                    }
                },
                dismissButton = {
                    Button(onClick = { showDialog = false }) { Text("Cancelar") }
                }
            )
        }
    }
}
@Composable
fun SeccionExamen(examen: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }, // Llama al callback cuando se hace clic
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ListAlt,
                contentDescription = examen,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = examen,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}