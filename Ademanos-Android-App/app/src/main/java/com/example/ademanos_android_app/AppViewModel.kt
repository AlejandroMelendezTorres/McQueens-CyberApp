package com.example.ademanos_android_app

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

// This model will also handle user and authentication state,
// so it can be shared across the app
class AppViewModel : ViewModel() {
    private var _selectedScreen by mutableStateOf(0)
    val selectedScreen: Int get() = _selectedScreen

    private val _snackbarHostState = SnackbarHostState()
    val snackbarHostState: SnackbarHostState get() = _snackbarHostState

    fun selectScreen(i: Int) {
        if (loginLoading) return
        _selectedScreen = i
    }


    private var _loginLoading by mutableStateOf(false)
    val loginLoading: Boolean get() = _loginLoading

    fun onLogin(email: String, password: String) {
        _loginLoading = true
        // TODO: handle login
        _loginLoading = false
        onLoginError()
    }

    fun onLoginError() {
        viewModelScope.launch {
            snackbarHostState.showSnackbar("Ocurrió un error, verifica tu información", duration = SnackbarDuration.Short)
        }
    }
}