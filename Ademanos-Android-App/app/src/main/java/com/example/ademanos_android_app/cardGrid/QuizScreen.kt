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
import com.example.ademanos_android_app.LEVEL_TAB
import com.example.ademanos_android_app.R

@Composable
fun QuizzScreen(modifier: Modifier = Modifier, quizCategoryViewModel: QuizViewModel = hiltViewModel()) {
    if (quizCategoryViewModel.loading) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CircularProgressIndicator()
        }
    } else {
        CardGrid(
            title = stringResource(R.string.quizz_title),
            data = quizCategoryViewModel.quizzes,
            nextScreen = LEVEL_TAB
        )
    }
}