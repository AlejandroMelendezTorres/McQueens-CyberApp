package com.example.ademanos_android_app.components

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object SnackbarManager {
    private val messages: MutableStateFlow<String?> = MutableStateFlow(null)
    val snackbarMessages: StateFlow<String?> get() = messages.asStateFlow()

    fun showMessage(m: String) {
        messages.value = m
    }
}

fun Throwable.toSnackbarMessage(): String {
    val message = this.message.orEmpty()
    return message.ifBlank {
        "Ocurrió un error"
    }
}