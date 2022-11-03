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
import androidx.compose.ui.tooling.preview.Preview
import com.example.ademanos_android_app.TEST_IMAGE
import com.example.ademanos_android_app.models.Question

@Composable
fun LevelTab(
    quizTitle: String,
    quizQuestion: Question,
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
            OptionCardGrid(quizQuestion,modifier=Modifier.padding(vertical = 10.dp, horizontal = 10.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OptionCardPreview() {
    OptionCard("Test",MaterialTheme.colorScheme.primary, 1,{})
}

@Preview(showBackground = true)
@Composable
fun OptionCardGridPreview() {
    val testQuestion = Question(
        "test",
        TEST_IMAGE,
        "¿Qué numero es este?",
        arrayOf("1","2","3","4"),
        1
    )
    OptionCardGrid(testQuestion)
}

@Preview(showBackground = true)
@Composable
fun SignImagePreview() {
    MediaItem(TEST_IMAGE)
}

@Preview(showBackground = true)
@Composable
fun LevelTabPreview() {
    val testQuestion = Question(
        "test",
        TEST_IMAGE,
        "¿Qué numero es este?",
        arrayOf("1","2","3","4"),
        1
    )
    LevelTab(
        "Nivel 1",
        testQuestion
    )
}