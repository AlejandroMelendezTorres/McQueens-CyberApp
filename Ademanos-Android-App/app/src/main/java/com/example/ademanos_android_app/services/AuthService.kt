package com.example.ademanos_android_app.services

import com.example.ademanos_android_app.models.User
import kotlinx.coroutines.flow.Flow

interface AuthService {
    val currentUserId: String
    val loggedIn: Boolean

    val currentUser: Flow<User?>

    suspend fun signIn(email: String, password: String)
    suspend fun signOut()
    suspend fun resetPassword(email: String)
}