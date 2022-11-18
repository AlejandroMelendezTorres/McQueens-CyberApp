package com.example.ademanos_android_app.models.events

import androidx.compose.runtime.Immutable

@Immutable
class LevelCompleted(
    uid: String,
    val sessionId: String,
    val quizId: String,
    val levelId: String,
    val correct: Boolean
) : GenericEvent("levelCompleted", uid)
