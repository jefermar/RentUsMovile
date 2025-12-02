package com.jefermar.rentusmovile.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jefermar.rentusmovile.screen.auth.LoginScreen
import com.jefermar.rentusmovile.screen.auth.RegisterScreen
import com.jefermar.rentusmovile.screen.home.HomeScreen
import com.jefermar.rentusmovile.screen.home.IniciadoScreen
import com.jefermar.rentusmovile.screen.navegation.AppRoutes

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.HOME // Home público como inicial
    ) {

        // HOME PÚBLICO
        composable(AppRoutes.HOME) {
            HomeScreen(
                onLoginClick = {
                    navController.navigate(AppRoutes.LOGIN)
                }
            )
        }

        // LOGIN
        composable(AppRoutes.LOGIN) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(AppRoutes.HOME_INICIADO) {
                        popUpTo(AppRoutes.LOGIN) { inclusive = true }
                    }
                },
                onGoToRegister = {
                    navController.navigate(AppRoutes.REGISTER)
                }
            )
        }

        // REGISTER
        composable(AppRoutes.REGISTER) {
            RegisterScreen(
                onGoToLogin = {
                    navController.popBackStack()
                }
            )
        }

        // HOME INICIADO (USUARIO LOGUEADO)
        composable(AppRoutes.HOME_INICIADO) {
            IniciadoScreen(
                onLogoutClick = {
                    navController.navigate(AppRoutes.HOME) {
                        popUpTo(AppRoutes.HOME_INICIADO) { inclusive = true }
                    }
                }
            )
        }
    }
}
