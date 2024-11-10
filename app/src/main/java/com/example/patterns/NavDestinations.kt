package com.example.patterns

sealed class NavDestinations(val route: String) {
    object Welcome : NavDestinations("welcome")
    object MvcCounter : NavDestinations("mvc_counter")
    object MvpCounter : NavDestinations("mvp_counter")
    object MvvmCounter : NavDestinations("mvvm_counter")
    object MviCounter : NavDestinations("mvi_counter")
}