package com.example.patterns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.patterns.screens.MvcCounterScreen
import com.example.patterns.screens.MviCounterScreen
import com.example.patterns.screens.MvpCounterScreen
import com.example.patterns.screens.MvvmCounterScreen
import com.example.patterns.screens.WelcomeScreen
import com.example.patterns.ui.theme.AndroidArchitecturePatternsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidArchitecturePatternsTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = NavDestinations.Welcome.route) {
                    composable(NavDestinations.Welcome.route) { WelcomeScreen(navController) }
                    composable(NavDestinations.MvcCounter.route) { MvcCounterScreen(navController) }
                    composable(NavDestinations.MvpCounter.route) { MvpCounterScreen(navController) }
                    composable(NavDestinations.MvvmCounter.route) { MvvmCounterScreen(navController) }
                    composable(NavDestinations.MviCounter.route) { MviCounterScreen(navController) }
                }
            }
        }
    }
}
