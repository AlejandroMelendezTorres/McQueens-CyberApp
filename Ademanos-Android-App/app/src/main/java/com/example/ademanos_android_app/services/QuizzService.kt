package com.example.ademanos_android_app.services

import com.example.ademanos_android_app.models.Question
import com.example.ademanos_android_app.models.Quiz

interface QuizService {
    suspend fun getQuizzes(categoryId: String): List<Quiz?>
    suspend fun getQuestions(categoryId: String,quizId: String): List<Question?>
}