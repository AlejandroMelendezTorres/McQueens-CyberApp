package com.example.ademanos_android_app.levelTab

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import com.example.ademanos_android_app.components.MediaItem
import androidx.compose.ui.tooling.preview.Preview
import com.example.ademanos_android_app.TEST_IMAGE
import com.example.ademanos_android_app.models.Question

@Composable
fun LevelTab(
    quizTitle: String,
    quizQuestion: Question,
    onSelect: (result: Boolean?) -> Unit,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
        Text(
            text = quizTitle,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Left,
            color =  MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp),
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