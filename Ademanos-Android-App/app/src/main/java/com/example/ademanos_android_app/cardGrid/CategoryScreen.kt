package com.example.ademanos_android_app.cardGrid

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ademanos_android_app.R
import com.example.ademanos_android_app.WORD_TAB
import com.example.ademanos_android_app.components.AdemanosButton

@Composable
fun CategoryScreen(modifier: Modifier = Modifier, categoryViewModel: CategoryViewModel = hiltViewModel()) {
    DisposableEffect(key1 = categoryViewModel) {
        categoryViewModel.onStart()
        onDispose { categoryViewModel.onStop() }
    }
    
    if (categoryViewModel.loading) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CircularProgressIndicator()
        }
    } else if (categoryViewModel.hasError) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                stringResource(id = R.string.generic_error),
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(5.1.dp))
            AdemanosButton(onClick = { categoryViewModel.onStart() }) {
                Text(stringResource(id = R.string.retry))
            }
        }
    } else {
        CardGrid(
            title = categoryViewModel.categoryName!!,
            data = categoryViewModel.words,
            nextScreen = WORD_TAB
        )
    }
}