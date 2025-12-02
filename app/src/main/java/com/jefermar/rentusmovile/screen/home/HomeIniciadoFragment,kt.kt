package com.jefermar.rentusmovile.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IniciadoScreen(onLogoutClick: () -> Unit) {

    // Fondo degradado igual al login / home
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF6F4E37), // café
            Color.White        // blanco suave
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Inicio") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6F4E37),
                    titleContentColor = Color.White
                ),
                actions = {
                    TextButton(
                        onClick = onLogoutClick,
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = Color.White
                        )
                    ) {
                        Text("Cerrar sesión")
                    }
                }
            )
        }
    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient)  // Fondo degradado aplicado aquí
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Bienvenido a RentUS",
                style = MaterialTheme.typography.headlineMedium,
                color = Color(0xFF3E2723) // café oscuro elegante
            )
        }
    }
}
