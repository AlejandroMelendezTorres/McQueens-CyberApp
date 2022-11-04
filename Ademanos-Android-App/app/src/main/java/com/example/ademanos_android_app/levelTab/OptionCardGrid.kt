package com.example.ademanos_android_app.levelTab

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ademanos_android_app.models.Question

@Composable
fun OptionCardGrid(
    quizQuestion: Question,
    onSelect: (result: Boolean?) -> Unit,
    modifier: Modifier = Modifier
){
    Surface(
        modifier = modifier
            .height(280.dp)
            .width(380.dp),
        shape = RoundedCornerShape(12.dp),
        color= MaterialTheme.colorScheme.onPrimaryContainer
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier= Modifier
                .padding(top = 20.dp)
        ) {
            Text(
                text = quizQuestion.prompt.uppercase(),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier,
                color = MaterialTheme.colorScheme.primaryContainer
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier= Modifier
                    .padding(top = 20.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier= Modifier
                ) {
                    OptionCard(
                        text = quizQuestion.options[0],
                        color = MaterialTheme.colorScheme.primary,
                        index = 0,
                        onclick = { evaluateAnswer(0,quizQuestion,onSelect) }
                    )
                    OptionCard(
                        text = quizQuestion.options[1],
                        color = MaterialTheme.colorScheme.secondary,
                        index = 1,
                        onclick = { evaluateAnswer(1,quizQuestion,onSelect) }
                    )
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier= Modifier
                ) {
                    OptionCard(
                        text = quizQuestion.options[2],
                        color = MaterialTheme.colorScheme.tertiary,
                        index = 2,
                        onclick = { evaluateAnswer(2,quizQuestion,onSelect) }
                    )
                    OptionCard(
                        text = quizQuestion.options[3],
                        color = MaterialTheme.colorScheme.error,
                        index = 3,
                        onclick = { evaluateAnswer(3,quizQuestion,onSelect) }
                    )
                }
            }
        }
    }
}

fun evaluateAnswer(
    index: Int,
    quizQuestion: Question,
    onSelect: (result: Boolean?) -> Unit)
{
    if (quizQuestion.answer==index){
        onSelect.invoke(true)
    }
    onSelect.invoke(false)
}
