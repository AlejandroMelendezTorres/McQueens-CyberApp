package com.example.ademanos_android_app.models

import androidx.compose.runtime.Immutable
import com.google.firebase.firestore.DocumentId

@Immutable
data class Quiz constructor(
    @DocumentId val id : String = "",
    var categoryId : String = "",
    var title: String = "",
    var description: String = "",
    var questions: List<Question> = listOf()
) : CardGridElement {
    override fun getDisplayTitle(): String {
        return title
    }
}