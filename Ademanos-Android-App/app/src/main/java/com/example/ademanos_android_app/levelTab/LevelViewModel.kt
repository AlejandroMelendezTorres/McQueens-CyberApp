package com.example.ademanos_android_app.levelTab

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.ademanos_android_app.AdemanosViewModel
import com.example.ademanos_android_app.components.NavigationManager
import com.example.ademanos_android_app.models.Quiz
import com.example.ademanos_android_app.models.events.LevelCompleted
import com.example.ademanos_android_app.models.events.QuizCompleted
import com.example.ademanos_android_app.models.events.QuizStarted
import com.example.ademanos_android_app.services.AuthService
import com.example.ademanos_android_app.services.QuizService
import com.example.ademanos_android_app.services.TrackingService
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class LevelViewModel @Inject constructor(
    private val quizService: QuizService,
    private val trackingService: TrackingService,
    private val authService: AuthService,
) : AdemanosViewModel() {

    private var selectedQuiz: Quiz? = null
    private var sessionId: String = ""

    private var _loading by mutableStateOf(true)
    val loading: Boolean get() = _loading

    private var _hasError by mutableStateOf(false)
    val hasError: Boolean get() = _hasError

    private var correct = 0
    private var incorrect = 0

    fun onStart() {
        val args = NavigationManager.args
        if (args is Quiz) {
            selectedQuiz = args
        } else {
            _hasError = true
            return
        }
        sessionId = UUID.randomUUID().toString()
        launchCatching {
            trackingService.trackEvent(
                QuizStarted(
                    authService.currentUserId,
                    selectedQuiz!!.id,
                    selectedQuiz!!.title,
                    sessionId
                )
            )
        }
        loadQuestions()
    }

    fun onStop() {
        selectedQuiz = null
        _loading = true
        _hasError = false
        _currentLevel = 0
        _popupControl = false
        _correctAnswer = false
        _popupText = "Respuesta incorrecta"
        _popupButtonText = "Intentar de nuevo"
        sessionId = ""
        correct = 0
        incorrect = 0
    }

    fun loadQuestions() {
        if (selectedQuiz == null) return
        _loading = true
        _hasError = false
        launchCatching(onError = {
            _hasError = true
            _loading = false
        }) {
            selectedQuiz!!.questions =
                quizService.getQuestions(selectedQuiz!!.categoryId, selectedQuiz!!.id)
                    .filterNotNull()
            _loading = false
        }
    }

    private var _currentLevel by mutableStateOf(0)
    val currentLevel: Int get() = _currentLevel

    private fun increaseLevel() {
        _currentLevel += 1
    }

    private var _popupControl by mutableStateOf(false)
    val popupControl: Boolean get() = _popupControl

    private fun onPopupControlChange(boolean: Boolean) {
        _popupControl = boolean
    }

    private var _correctAnswer by mutableStateOf(false)
    val correctAnswer: Boolean get() = _correctAnswer

    private fun onCorrectAnswerChange(boolean: Boolean) {
        _correctAnswer = boolean
    }

    private var _popupText by mutableStateOf("Respuesta incorrecta")
    val popupText: String get() = _popupText

    private var _popupButtonText by mutableStateOf("Intentar de nuevo")
    val popupButtonText: String get() = _popupButtonText

    private fun onPopupTextChange(popText: String, popButtonText: String) {
        _popupText = popText
        _popupButtonText = popButtonText
    }

    fun evaluatePopupControl(result: Boolean) {
        onPopupControlChange(result)
        if (correctAnswer) {
            increaseLevel()
            onCorrectAnswerChange(false)
            onPopupTextChange("Respuesta incorrecta", "Intentar de nuevo")
        }
    }

    fun evaluateQuizResult(result: Boolean, numberOfQuestions: Int): Boolean {
        launchCatching {
            trackingService.trackEvent(
                LevelCompleted(
                    authService.currentUserId,
                    sessionId,
                    selectedQuiz!!.id,
                    selectedQuiz!!.questions[currentLevel].id,
                    result
                )
            )
        }
        if (result) {
            correct += 1
            if (currentLevel == numberOfQuestions - 1) {
                onCorrectAnswerChange(true)
                onPopupTextChange("Respuesta Correcta", "Continuar")
                launchCatching {
                    trackingService.trackEvent(
                        QuizCompleted(
                            authService.currentUserId,
                            selectedQuiz!!.id,
                            selectedQuiz!!.title,
                            sessionId,
                            correct,
                            incorrect,
                        )
                    )
                }
                return true
            }
            onCorrectAnswerChange(true)
            onPopupTextChange("Respuesta Correcta", "Continuar")
        } else {
            incorrect += 1
        }
        onPopupControlChange(true)
        return false
    }

}
