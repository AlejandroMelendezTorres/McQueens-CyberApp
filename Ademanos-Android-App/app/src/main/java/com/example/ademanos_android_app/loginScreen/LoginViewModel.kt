package com.example.ademanos_android_app.loginScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.ademanos_android_app.AdemanosViewModel
import com.example.ademanos_android_app.services.AuthService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authService: AuthService) : AdemanosViewModel() {
    private var _email by mutableStateOf("")
    val email: String get() = _email

    private var _loading by mutableStateOf(false)
    val loading: Boolean get() = _loading

    private var _emailValid by mutableStateOf(true)
    val emailValid: Boolean get() = _emailValid

    fun onEmailChange(v: String) {
        _email = v
        _emailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(v).matches()
    }

    private var _password by mutableStateOf("")
    val password: String get() = _password

    private var _passwordValid by mutableStateOf(true)
    val passwordValid: Boolean get() = _passwordValid

    fun onPasswordChange(v: String) {
        _password = v
        _passwordValid = v.length >= 8
    }

    val buttonEnabled: Boolean get() = _emailValid &&
            _passwordValid && _email.isNotEmpty() &&
            password.isNotEmpty()

    fun onLogin() {
        _loading = true
        launchCatching(onError = {_loading = false}) {
            authService.signIn(email, password)
            _loading = false
        }
    }
}