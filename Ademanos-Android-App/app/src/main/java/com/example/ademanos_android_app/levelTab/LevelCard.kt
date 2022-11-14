package com.example.ademanos_android_app.levelTab

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import com.example.ademanos_android_app.components.MediaItem
import com.example.ademanos_android_app.models.Question

@Composable
fun LevelCard(
    quizTitle: String,
    quizQuestion: Question,
    onSelect: (result: Boolean?) -> Unit,
    modifier: Modifier = Modifier
){
    var shortTitle=quizTitle
    if (quizTitle.length>20){
        shortTitle=quizTitle.slice(0..20)+"..."
    }
    Column(modifier = modifier) {
        Text(
            text = shortTitle,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Left,
            color =  MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            MediaItem(quizQuestion.media,modifier=Modifier.padding(vertical = 10.dp))
            OptionCardGrid(quizQuestion, onSelect,Modifier.padding(horizontal = 10.dp))
        }
    }
}