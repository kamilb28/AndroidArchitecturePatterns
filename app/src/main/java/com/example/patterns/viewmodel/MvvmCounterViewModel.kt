package com.example.patterns.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.patterns.models.CounterModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MvvmCounterViewModel : ViewModel() {
    private val counterModel = CounterModel()

    private val _counter = MutableStateFlow(counterModel.count)
    val counter: StateFlow<Int> = _counter

    fun incrementCounter() {
        viewModelScope.launch {
            // TODO [MVVM]: use method in counterModel to increment value then pass this value to MutableStateFlow of counterModel value
        }
    }
}
