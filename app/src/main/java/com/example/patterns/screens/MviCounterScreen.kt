package com.example.patterns.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.patterns.mvi.CounterIntent
import com.example.patterns.mvi.CounterViewModel

@Composable
fun MviCounterScreen(
    navController: NavHostController,
    viewModel: CounterViewModel = viewModel()
) {
    val counterState = viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Color(0xFFF5F5F5)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("MVI Counter", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3A3A3A))

        Spacer(modifier = Modifier.height(24.dp))

        Text("Counter: ${counterState.value.count}", fontSize = 36.sp, fontWeight = FontWeight.Bold, color = Color(0xFF009688))

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            // TODO [MVI]: make button increment value, use math oer in viewModel to send intent (see CounterIntent class)
            onClick = { /* here */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF009688), contentColor = Color.White),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            Text("+", fontSize = 18.sp, fontWeight = FontWeight.Medium)
        }

        Button(
            // TODO [MVI]: make button increment value, use math oer in viewModel to send intent (see CounterIntent class)
            onClick = { /* here */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD32F2F), contentColor = Color.White),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Reset", fontSize = 18.sp, fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Back to Menu")
        }
    }
}
