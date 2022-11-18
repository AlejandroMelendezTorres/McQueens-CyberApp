package com.example.ademanos_android_app.wordView

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.ademanos_android_app.AdemanosViewModel
import com.example.ademanos_android_app.components.NavigationManager
import com.example.ademanos_android_app.models.Word
import com.example.ademanos_android_app.models.events.WordView
import com.example.ademanos_android_app.services.AuthService
import com.example.ademanos_android_app.services.TrackingService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WordViewModel @Inject constructor(private val trackingService: TrackingService, private val auth: AuthService) : AdemanosViewModel() {
    private var _hasError by mutableStateOf(false)
    val hasError: Boolean get() = _hasError

    private var _word by mutableStateOf<Word?>(null)
    val word: Word? get() = _word

    fun init() {
        if (NavigationManager.args is Word) {
            _word = NavigationManager.args as Word
        } else {
            _hasError = true
            return
        }
        launchCatching {
            trackingService.trackEvent(WordView(auth.currentUserId, word!!.id, word!!.name))
        }
    }

    fun onClose() {
        _word = null
        _hasError = false
    }
}