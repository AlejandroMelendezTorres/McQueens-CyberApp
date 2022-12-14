package com.example.ademanos_android_app.models

import androidx.compose.runtime.Immutable
import com.google.firebase.firestore.DocumentId

@Immutable
data class Word constructor (
    @DocumentId val id : String = "",
    val name : String = "",
    val description : String = "",
    val media : String = ""
) : CardGridElement {
    override fun getDisplayTitle(): String {
        return name
    }
}