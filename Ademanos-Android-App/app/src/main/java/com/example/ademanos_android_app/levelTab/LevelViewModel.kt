package com.example.ademanos_android_app.levelTab

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LevelViewModel: ViewModel() {

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

    private var _correctAnswer by mutableStateOf (false)
    val correctAnswer: Boolean get() = _correctAnswer

    private fun onCorrectAnswerChange(boolean: Boolean) {
        _correctAnswer = boolean
    }

    private var _popupText by mutableStateOf ("Respuesta incorrecta")
    val popupText: String get() = _popupText

    private var _popupButtonText by mutableStateOf ("Intentar de nuevo")
    val popupButtonText: String get() = _popupButtonText

    private fun onPopupTextChange(popText: String, popButtonText: String) {
        _popupText = popText
        _popupButtonText = popButtonText
    }

    fun evaluatePopupControl(result: Boolean) {
        onPopupControlChange(result)
        if (correctAnswer){
            increaseLevel()
            onCorrectAnswerChange(false)
            onPopupTextChange("Respuesta incorrecta","Intentar de nuevo")
        }
    }

    fun evaluateQuizResult(result: Boolean, numberOfQuestions:Int): Boolean {
        if (result){
            if (currentLevel==numberOfQuestions-1){
                return true
            }
            onCorrectAnswerChange(true)
            onPopupTextChange("Respuesta Correcta","Continuar")
        }
        onPopupControlChange(true)
        return false
    }

}