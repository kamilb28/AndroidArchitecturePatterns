package com.example.patterns.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CounterViewModel : ViewModel() {

    // Internal state of the counter
    private val _state = MutableStateFlow(CounterState())
    val state: StateFlow<CounterState> = _state.asStateFlow()

    // Channel to handle intents
    private val intentChannel = Channel<CounterIntent>(Channel.UNLIMITED)

    init {
        handleIntents()
    }

    fun sendIntent(intent: CounterIntent) {
        viewModelScope.launch {
            intentChannel.send(intent)
        }
    }

    private fun handleIntents() {
        // TODO complete handling the user's actins, use `switch` or kotlin's `when` to determine
        //  if to increment or reset counter (see CounterIntent class), then remove above's return statement
        viewModelScope.launch {
            intentChannel.consumeAsFlow().collect { intent ->
                when (intent) {
                    is CounterIntent.Increment -> incrementCounter()
                    is CounterIntent.Reset -> resetCounter()
                }
            }
        }
    }

    private fun incrementCounter() {
        _state.update { currentState ->
            currentState.copy(count = currentState.count + 1)
        }
    }

    private fun resetCounter() {
        _state.update { CounterState() }
    }
}
