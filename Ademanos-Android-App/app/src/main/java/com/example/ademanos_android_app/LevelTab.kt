package com.example.ademanos_android_app


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.ademanos_android_app.ui.theme.QuizQuestion


@Composable
fun OptionCard(
    text: String,
    color: Color,
    modifier: Modifier = Modifier
){
    Button(
        onClick = { /*TODO*/ },
        modifier= modifier
            .height(84.dp)
            .width(170.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )
    ) {
        Box(
            contentAlignment=Alignment.Center,
            modifier=Modifier
        ){
            Text(
                text = text.uppercase(),
                textAlign=TextAlign.Center,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .wrapContentHeight()
            )
        }
    }
}

@Composable
fun OptionCardGrid(
    quizQuestion: QuizQuestion,
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
            modifier=Modifier
                .padding(top = 20.dp)
        ) {
            Text(
                text = quizQuestion.question.uppercase(),
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
                    modifier=Modifier
                ) {
                    OptionCard(text = quizQuestion.options[0], color = MaterialTheme.colorScheme.primary)
                    OptionCard(text = quizQuestion.options[1], color = MaterialTheme.colorScheme.secondary)
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier=Modifier
                ) {
                    OptionCard(text = quizQuestion.options[2], color = MaterialTheme.colorScheme.tertiary)
                    OptionCard(text = quizQuestion.options[3], color = MaterialTheme.colorScheme.error)
                }
            }
        }
    }
}

@Composable
fun SignImage(
    @DrawableRes drawable: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = drawable),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .height(300.dp)
            .width(300.dp)
    )
}

@Composable
fun LevelTab(
    quizQuestion: QuizQuestion,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
        Text(
            text = "Nivel ${quizQuestion.levelNumber}",
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
            SignImage(R.drawable.number_1,modifier=Modifier.padding(vertical = 10.dp))
            OptionCardGrid(quizQuestion,modifier=Modifier.padding(vertical = 10.dp, horizontal = 10.dp))
        }
        LevelBottomNavigation()
    }
}

@Composable
private fun LevelBottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier=modifier
    ){
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.book_solid),
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
            },
            selected = false,
            onClick = { /*TODO*/ }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.gamepad_solid),
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
            },
            selected = true,
            onClick = { /*TODO*/ }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.user_solid),
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
            },
            selected = false,
            onClick = { /*TODO*/ }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OptionCardPreview() {
    OptionCard("Test",MaterialTheme.colorScheme.primary)
}

@Preview(showBackground = true)
@Composable
fun OptionCardGridPreview() {
    val testQuestion = QuizQuestion(
        1,
        "Test question", arrayOf(
            "Option 1","Option 2","Option 3","Option 4"
            ),
        "Option 1")
    OptionCardGrid(testQuestion)
}

@Preview(showBackground = true)
@Composable
fun SignImagePreview() {
    SignImage(R.drawable.number_1)
}

@Preview(showBackground = true)
@Composable
fun LevelTabPreview() {
    val testQuestion = QuizQuestion(
        1,
        "Test question", arrayOf(
            "Option 1","Option 2","Option 3","Option 4"
        ),
        "Option 1")
    LevelTab(testQuestion)
}

@Preview(showBackground = true)
@Composable
fun LevelBottomNavigationPreview() {
    LevelBottomNavigation()
}