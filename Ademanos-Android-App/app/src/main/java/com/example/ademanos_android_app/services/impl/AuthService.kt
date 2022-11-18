package com.example.ademanos_android_app.services.impl

import android.util.Log
import com.example.ademanos_android_app.models.User
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject
import com.example.ademanos_android_app.services.AuthService
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.tasks.await

class AuthServiceImpl @Inject constructor(private val auth: FirebaseAuth, private val firestore: FirebaseFirestore) : AuthService {
    override val loggedIn: Boolean get() = auth.currentUser != null
    override val currentUserId: String
        get() = auth.currentUser?.uid.orEmpty()
    private val _currentUser: MutableStateFlow<User?> = MutableStateFlow(null)
    private lateinit var _registration: ListenerRegistration
    override val currentUser get() = _currentUser

    private val listener = FirebaseAuth.AuthStateListener {
        if (it.currentUser == null) {
            _currentUser.value = null
        } else {
            _currentUser.value=User("loading", "", "", "",0,0, Timestamp.now())
            _registration=firestore.collection("users")
                .document(auth.currentUser!!.uid)
                .addSnapshotListener{snapshot, e ->
                    if (e!=null){
                        Log.println(Log.ERROR, "DB", e.message.orEmpty())
                        auth.signOut()
                    }
                    else{
                        _currentUser.value=snapshot!!.toObject<User>()
                    }
                }
        }
    }

    init {
        auth.addAuthStateListener(listener)
    }

    protected fun finalize(){
        auth.removeAuthStateListener(listener)
        _registration.remove()
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