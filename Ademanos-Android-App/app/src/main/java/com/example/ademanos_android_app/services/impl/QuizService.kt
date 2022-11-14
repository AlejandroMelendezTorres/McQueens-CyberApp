package com.example.ademanos_android_app.services.impl

import com.example.ademanos_android_app.models.Question
import com.example.ademanos_android_app.models.Quiz
import com.example.ademanos_android_app.services.QuizService
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class QuizServiceImpl @Inject constructor(private val firestore: FirebaseFirestore) : QuizService {

    override suspend fun getQuizzes(categoryId: String): List<Quiz?> {
        return firestore
            .collection("categories")
            .document(categoryId)
            .collection("quizz")
            .get()
            .await()
            .documents.map { d -> d?.toObject<Quiz>()  }
    }

    override suspend fun getQuestions(categoryId: String,quizId: String): List<Question?> {
        return firestore
            .collection("categories")
            .document(categoryId)
            .collection("quizz")
            .document(quizId)
            .collection("questions")
            .get()
            .await()
            .documents.map { d -> d?.toObject<Question>()  }
    }

}