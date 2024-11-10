package com.example.patterns.controllers

import androidx.compose.runtime.MutableState
import com.example.patterns.models.CounterModel
import com.example.patterns.models.MessageModel

class MvcController(
    private val counterState: MutableState<Int>
) {
    private val counterModel = CounterModel()

    init {
        println("MvcController initialized") // To verify it's only initialized once
    }

    fun incrementCounter() {
        // Update the model
        println("Current counter value 1: ${counterState.value}")
        counterModel.increment()
        println("Current counter value 2: ${counterState.value}")
        // Reflect the model's state in the UI state
        println("Current counter value 3: ${counterState.value}")
        counterState.value = counterModel.count
        println("Current counter value 4: ${counterState.value}")
    }
}