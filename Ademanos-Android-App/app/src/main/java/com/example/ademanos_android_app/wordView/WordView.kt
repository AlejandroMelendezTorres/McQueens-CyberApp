package com.example.ademanos_android_app.wordView

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ademanos_android_app.R
import com.example.ademanos_android_app.components.AdemanosButton
import com.example.ademanos_android_app.components.MediaItem

@Composable
fun WordView(modifier: Modifier = Modifier, wordViewModel: WordViewModel = hiltViewModel()){
    DisposableEffect(key1 = wordViewModel) {
        wordViewModel.init()
        onDispose { wordViewModel.onClose() }
    }

    if (wordViewModel.hasError) {
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
            AdemanosButton(onClick = { wordViewModel.init() }) {
                Text(stringResource(id = R.string.retry))
            }
        }
    } else if (wordViewModel.word != null) {
        Column() {
            Text(
                text = wordViewModel.word!!.name,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Left,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                MediaItem(wordViewModel.word!!.media, modifier = Modifier
                    .padding(vertical = 10.dp)
                    .semantics { testTag = wordViewModel.word!!.media})
            }
        }
    }
}