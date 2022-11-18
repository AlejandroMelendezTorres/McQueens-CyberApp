package com.example.ademanos_android_app.models.events

import androidx.compose.runtime.Immutable

@Immutable
class QuizStarted(uid: String, val quizId: String, val quizName: String, val sessionId: String) :
    GenericEvent("quizStarted", uid)
