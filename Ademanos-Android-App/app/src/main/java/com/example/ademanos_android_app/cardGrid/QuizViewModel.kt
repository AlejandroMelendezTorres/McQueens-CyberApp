package com.example.ademanos_android_app.cardGrid

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.ademanos_android_app.AdemanosViewModel
import com.example.ademanos_android_app.models.Category
import com.example.ademanos_android_app.models.Quiz
import com.example.ademanos_android_app.services.DictionaryService
import com.example.ademanos_android_app.services.QuizService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(private val quizService: QuizService, private val dictionaryService: DictionaryService) : AdemanosViewModel() {
    private var _loading by mutableStateOf(true)
    val loading: Boolean get() = _loading

    private var _quizzes by mutableStateOf<List<Quiz>>(emptyList())
    val quizzes: List<Quiz> get() = _quizzes

    init {
        loadQuizz()
    }

    private fun loadQuizz() {
        _loading = true
        launchCatching {
            val categories = dictionaryService.getCategories().filterNotNull()
            val curQuizList = mutableListOf<Quiz>()
            for (category in categories){
                val curQuiz=quizService.getQuizzes(category.id).filterNotNull()
                for (quiz in curQuiz){
                    quiz.categoryId=category.id
                }
                curQuizList.addAll(curQuiz)
            }
            _quizzes=curQuizList.toList()
            _loading = false
        }
    }
}