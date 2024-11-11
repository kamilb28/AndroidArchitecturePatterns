package com.example.patterns.controllers

import androidx.compose.runtime.MutableState
import com.example.patterns.models.CounterModel
import com.example.patterns.models.MessageModel

class MvcController(
    private val counterState: MutableState<Int>
) {
    private val counterModel = CounterModel()

    // TODO [MVC]: create increment function, use counterModel.kt and remember to update counterState value
}