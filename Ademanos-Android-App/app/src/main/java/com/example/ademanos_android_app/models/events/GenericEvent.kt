package com.example.ademanos_android_app.models.events

import androidx.compose.runtime.Immutable
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.ServerTimestamp

@Immutable
open class GenericEvent(
    val type: String,
    val uid: String,
    val timestamp: FieldValue = FieldValue.serverTimestamp()
)