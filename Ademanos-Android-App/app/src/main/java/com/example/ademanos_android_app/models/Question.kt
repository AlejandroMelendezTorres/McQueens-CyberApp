package com.example.ademanos_android_app.models

import androidx.compose.runtime.Immutable
import com.google.firebase.firestore.DocumentId

@Immutable
data class Question (
    @DocumentId val id : String = "",
    var media: String = "",
    var prompt: String = "",
    var options: List<String> = emptyList() ,
    var answer: Int = 0
)