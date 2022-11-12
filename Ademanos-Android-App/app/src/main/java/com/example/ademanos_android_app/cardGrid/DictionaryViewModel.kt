package com.example.ademanos_android_app.cardGrid

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.ademanos_android_app.AdemanosViewModel
import com.example.ademanos_android_app.models.Category
import com.example.ademanos_android_app.services.DictionaryService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DictionaryViewModel @Inject constructor(private val dictionaryService: DictionaryService) : AdemanosViewModel() {
    private var _loading by mutableStateOf(true)
    val loading: Boolean get() = _loading

    private var _categories by mutableStateOf<List<Category>>(emptyList())
    val categories: List<Category> get() = _categories

    init {
        loadCategories()
    }

    fun loadCategories() {
        _loading = true
        launchCatching {
            _categories = dictionaryService.getCategories().filterNotNull()
            _loading = false
        }
    }
}