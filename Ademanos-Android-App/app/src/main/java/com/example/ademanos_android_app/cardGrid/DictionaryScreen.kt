package com.example.ademanos_android_app.cardGrid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ademanos_android_app.CATEGORY_TAB
import com.example.ademanos_android_app.R

@Composable
fun DictionaryScreen(modifier: Modifier = Modifier, dictionaryViewModel: DictionaryViewModel = hiltViewModel()) {
    if (dictionaryViewModel.loading) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CircularProgressIndicator()
        }
    } else {
        CardGrid(
            title = stringResource(id = R.string.dictionary_title),
            data = dictionaryViewModel.categories,
            nextScreen = CATEGORY_TAB
        )
    }
}