package com.example.patterns.mvi

sealed class CounterIntent {
    object Increment : CounterIntent()
    object Reset : CounterIntent()
}
