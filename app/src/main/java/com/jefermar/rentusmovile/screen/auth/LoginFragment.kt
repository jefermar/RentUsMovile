package com.jefermar.rentusmovile.screen.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onGoToRegister: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Fondo degradado global (fuera de la tarjeta)
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF6F4E37), // Café
            Color.White        // Blanco suave
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)         // AQUÍ: fondo degradado fuera de la card
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Título
                Text(
                    text = "Iniciar sesión",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color(0xFF6F4E37)
                )

                // EMAIL
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Correo") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                // PASSWORD
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Contraseña") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                // BOTÓN PRINCIPAL
                Button(
                    onClick = onLoginSuccess,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF6F4E37),
                        contentColor = Color.White
                    )
                ) {
                    Text("Entrar", fontSize = 17.sp)
                }

                // BOTÓN SECUNDARIO
                TextButton(
                    onClick = onGoToRegister
                ) {
                    Text(
                        "Crear cuenta",
                        fontSize = 15.sp,
                        color = Color(0xFF6F4E37)
                    )
                }
            }
        }
    }
}
