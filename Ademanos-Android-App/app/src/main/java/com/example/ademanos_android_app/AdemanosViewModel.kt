package com.example.ademanos_android_app

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ademanos_android_app.components.SnackbarManager
import com.example.ademanos_android_app.components.toSnackbarMessage
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

open class AdemanosViewModel : ViewModel() {
    fun launchCatching(snackbar: Boolean = true, onError: () -> Unit = {}, block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(
            CoroutineExceptionHandler { _, throwable ->
                onError()
                if (snackbar) {
                    SnackbarManager.showMessage(throwable.toSnackbarMessage())
                }
                Log.println(Log.ERROR, "ASYNC_ERROR", throwable.toSnackbarMessage())
            },
            block = block
        )
    }
}