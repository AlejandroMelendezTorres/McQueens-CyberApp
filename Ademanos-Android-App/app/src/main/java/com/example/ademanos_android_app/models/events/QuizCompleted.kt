package com.example.ademanos_android_app.models.events

import androidx.compose.runtime.Immutable

@Immutable
class QuizCompleted(
    uid: String,
    val quizId: String,
    val quizName: String,
    val sessionId: String,
    val correct: Int,
    val incorrect: Int
) :
    GenericEvent("quizCompleted", uid)
