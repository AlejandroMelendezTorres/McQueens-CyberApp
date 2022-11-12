package com.example.ademanos_android_app.services.impl

import com.example.ademanos_android_app.models.Category
import com.example.ademanos_android_app.models.Word
import com.example.ademanos_android_app.services.DictionaryService
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class DictionaryServiceImpl @Inject constructor(private val firestore: FirebaseFirestore) : DictionaryService {
    override suspend fun getCategories(): List<Category?> {
        return firestore
            .collection("categories")
            .get()
            .await()
            .documents.map<DocumentSnapshot?, Category?> { d -> d?.toObject<Category>() }
    }

    override suspend fun getWords(categoryId: String): List<Word?> {
        return firestore
            .collection("categories")
            .document(categoryId)
            .collection("words")
            .get()
            .await()
            .documents.map { d -> d?.toObject<Word>()  }
    }
}