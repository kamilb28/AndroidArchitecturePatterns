package com.example.patterns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.patterns.screens.MvcCounterScreen
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
                    composable(NavDestinations.MvpCounter.route) { MvcCounterScreen(navController) }
                }
            }
        }
    }
}

//package com.example.patterns
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.mutableIntStateOf
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.patterns.controllers.MvcController
//import com.example.patterns.ui.theme.AndroidArchitecturePatternsTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            AndroidArchitecturePatternsTheme {
//                // Define the state variable for the message
//                val counterState = remember { mutableStateOf(0) }
//
//                // Instantiate the controller with the message state
//                val controller = remember { MvcController(counterState) }
//
//                // Display the UI
//                Column(
//                    modifier = Modifier.fillMaxSize(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center
//                ) {
//                    Text(
//                        text = "Counter App in MVC Pattern",
//                        fontSize = 24.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = Color(0xFF3A3A3A)
//                    )
//
//                    Spacer(modifier = Modifier.height(24.dp))
//
//                    // Counter Display
//                    Text(
//                        text = "Counter: ${counterState.value}",
//                        fontSize = 36.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = Color(0xFFD32F2F),
//                        modifier = Modifier.padding(16.dp)
//                    )
//
//                    Spacer(modifier = Modifier.height(24.dp))
//
//                    // Button
//                    Button(
//                        onClick = { controller.incrementCounter() },
//                        colors = ButtonDefaults.buttonColors(
//                            containerColor = Color(0xFF1E88E5),
//                            contentColor = Color.White
//                        ),
//                        shape = RoundedCornerShape(12.dp),
//                        modifier = Modifier
//                            .padding(8.dp)
//                            .size(width = 60.dp, height = 60.dp)
//                    ) {
//                        Text(
//                            text = "+",
//                            fontSize = 18.sp,
//                            fontWeight = FontWeight.Medium
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
