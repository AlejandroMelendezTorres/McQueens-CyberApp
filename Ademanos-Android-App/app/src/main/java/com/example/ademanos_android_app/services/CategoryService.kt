package com.example.ademanos_android_app.services

import com.example.ademanos_android_app.models.Category
import com.example.ademanos_android_app.models.Word

interface DictionaryService {
    suspend fun getCategories(): List<Category?>
    suspend fun getWords(categoryId: String): List<Word?>
}