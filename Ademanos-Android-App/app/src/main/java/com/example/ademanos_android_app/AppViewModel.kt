package com.example.ademanos_android_app

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ademanos_android_app.components.NavigationManager
import com.example.ademanos_android_app.components.SnackbarManager
import com.example.ademanos_android_app.services.AuthService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val authService: AuthService) : AdemanosViewModel() {
    private var _selectedScreen by mutableStateOf(0)
    val selectedScreen: Int get() = _selectedScreen

    private val _snackbarHostState = SnackbarHostState()
    val snackbarHostState: SnackbarHostState get() = _snackbarHostState

    init {
        viewModelScope.launch {
            SnackbarManager.snackbarMessages.filterNotNull().collect {m ->
                snackbarHostState.showSnackbar(m, duration = SnackbarDuration.Short)
            }
        }
        viewModelScope.launch {
            NavigationManager.navigationMessages.filterNotNull().collect {m ->
                _selectedScreen = m.screen
            }
        }
    }

    val currentUser get() = authService.currentUser

    fun onSignOut() {
        launchCatching {
            authService.signOut()
        }
    }

}