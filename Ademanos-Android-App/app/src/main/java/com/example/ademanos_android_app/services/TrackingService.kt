package com.example.ademanos_android_app.services

import com.example.ademanos_android_app.models.events.GenericEvent

interface TrackingService {
    suspend fun trackEvent(event: GenericEvent)
}