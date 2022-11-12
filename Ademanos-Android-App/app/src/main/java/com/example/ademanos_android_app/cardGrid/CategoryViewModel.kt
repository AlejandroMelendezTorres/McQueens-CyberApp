package com.example.ademanos_android_app.cardGrid

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.ademanos_android_app.AdemanosViewModel
import com.example.ademanos_android_app.components.NavigationManager
import com.example.ademanos_android_app.models.Category
import com.example.ademanos_android_app.models.Word
import com.example.ademanos_android_app.services.DictionaryService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val dictionaryService: DictionaryService) : AdemanosViewModel() {
    private var selectedCategory: Category? = null
    val categoryName: String? get() = selectedCategory?.title

    private var _loading by mutableStateOf(true)
    val loading: Boolean get() = _loading

    private var _hasError by mutableStateOf(false)
    val hasError: Boolean get() = _hasError

    private var _words by mutableStateOf<List<Word>>(emptyList())
    val words: List<Word> get() = _words

    fun onStart() {
        val args = NavigationManager.args
        if (args is Category) {
            selectedCategory = args
        } else {
            _hasError = true
            return
        }

        loadWords()
    }

    fun onStop() {
        selectedCategory = null
        _loading = true
        _hasError = false
    }

    fun loadWords() {
        if (selectedCategory == null) return
        _loading = true
        _hasError = false
        launchCatching(onError = {
            _hasError = true
            _loading = false
        }) {
            _words = dictionaryService.getWords(categoryId = selectedCategory!!.id).filterNotNull()
            _loading = false
        }
    }
}