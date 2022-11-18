package com.example.ademanos_android_app.services.impl

import android.util.Log
import com.example.ademanos_android_app.models.events.GenericEvent
import com.example.ademanos_android_app.models.events.LevelCompleted
import com.example.ademanos_android_app.models.events.WordView
import com.example.ademanos_android_app.services.AuthService
import com.example.ademanos_android_app.services.TrackingService
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class TrackingServiceImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val authService: AuthService
) : TrackingService {
    override suspend fun trackEvent(event: GenericEvent) {
        if (authService.currentUserId == "") return
        firestore.collection("events").document().set(event).await()
        if (event.type == "wordView") {
            firestore.collection("users").document(event.uid)
                .update("consultedWords", FieldValue.increment(1)).await()
        } else if (event.type == "levelCompleted" && (event as LevelCompleted).correct) {
            firestore.collection("users").document(event.uid)
                .update("completedLevels", FieldValue.increment(1)).await()
        }
    }
}