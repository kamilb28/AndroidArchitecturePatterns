package com.example.patterns.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.patterns.NavDestinations
import com.example.patterns.controllers.MvcController
import com.example.patterns.mvp.MvpContract
import com.example.patterns.mvp.MvpPresenter

@Composable
fun MvpCounterScreen(navController: NavHostController) {
    val mvpCounterState = remember { mutableStateOf(0) }
    val presenter = remember { MvpPresenter() }
    presenter.attachView(object : MvpContract.View {
        override fun showCounter(counter: Int) {
            mvpCounterState.value = counter
        }
    })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Color(0xFFF5F5F5)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("MVP Counter", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3A3A3A))

        Spacer(modifier = Modifier.height(24.dp))

        Text("Counter: ${mvpCounterState.value}", fontSize = 36.sp, fontWeight = FontWeight.Bold, color = Color(0xFFD32F2F))

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { presenter.incrementCounter() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8E24AA), contentColor = Color.White),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            Text("+", fontSize = 18.sp, fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Back to Menu")
        }
    }
}