package com.jefermar.rentusmovile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jefermar.rentusmovile.navigation.AppNavigation
import com.jefermar.rentusmovile.ui.theme.RentUsMovileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            RentUsMovileTheme {
                AppNavigation()
            }
        }
    }
}
