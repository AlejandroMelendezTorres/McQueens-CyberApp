package com.example.ademanos_android_app.components

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class NavigationState(val screen: Int, val args: Any?)

object NavigationManager {
    private val messages: MutableStateFlow<NavigationState?> = MutableStateFlow(null)
    val navigationMessages: StateFlow<NavigationState?> = messages.asStateFlow()

    var args: Any? = null
    private set

    fun navigate(screen: Int, args: Any?) {
        messages.value = NavigationState(screen, args)
        this.args = args
    }
}