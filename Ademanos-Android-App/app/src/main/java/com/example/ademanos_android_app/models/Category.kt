package com.example.ademanos_android_app.models

import androidx.compose.runtime.Immutable
import com.google.firebase.firestore.DocumentId

@Immutable
data class Category constructor(
    @DocumentId val id: String = "",
    val title: String = "",
) : CardGridElement {
    override fun getDisplayTitle(): String {
        return title
    }
}