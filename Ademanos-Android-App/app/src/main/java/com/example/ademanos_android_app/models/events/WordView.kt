package com.example.ademanos_android_app.models.events

import androidx.compose.runtime.Immutable

@Immutable
class WordView constructor(
    uid: String,
    val wordId: String,
    val word: String,
) : GenericEvent("wordView", uid)