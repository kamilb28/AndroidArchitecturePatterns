package com.example.patterns.controllers

import androidx.compose.runtime.MutableState
import com.example.patterns.models.CounterModel
import com.example.patterns.models.MessageModel

class MvcController(
        private val messageState: MutableState<String>,
        private val counterState: MutableState<Int>) {
    private val messageModel = MessageModel()
    private val counterModel = CounterModel()

    fun updateMessage(){
        messageState.value = messageModel.message
    }

    fun incrementCounter(){
        counterModel.count++
        counterState.value = counterModel.count
        println("Current counter value: ${counterModel.count}")
        println("Current counter value: ${counterState.value}")
    }
}