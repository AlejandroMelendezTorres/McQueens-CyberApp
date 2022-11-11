package com.example.ademanos_android_app.services.impl

import android.util.Log
import com.example.ademanos_android_app.models.User
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject
import com.example.ademanos_android_app.services.AuthService
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class AuthServiceImpl @Inject constructor(private val auth: FirebaseAuth, private val firestore: FirebaseFirestore) : AuthService {
    override val loggedIn: Boolean get() = auth.currentUser != null
    override val currentUserId: String
        get() = auth.currentUser?.uid.orEmpty()

    override val currentUser: Flow<User?>
        get() = callbackFlow {
            val listener = FirebaseAuth.AuthStateListener {
                if (it.currentUser == null) {
                    this.trySend(null)
                } else {
                    this.trySend(User("loading", "", "", "", Timestamp.now()))
                    firestore.collection("users")
                        .document(auth.currentUser!!.uid)
                        .get()
                        .addOnSuccessListener { doc ->
                            this.trySend(doc.toObject<User>())
                        }
                        .addOnFailureListener { e ->
                            Log.println(Log.ERROR, "DB", e.message.orEmpty())
                            auth.signOut()
                        }
                }
            }
            auth.addAuthStateListener(listener)
            awaitClose { auth.removeAuthStateListener(listener) }
        }

    override suspend fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).await()
    }

    override suspend fun signOut() {
        auth.signOut()
    }

    override suspend fun resetPassword(email: String) {
        auth.sendPasswordResetEmail(email).await()
    }
}