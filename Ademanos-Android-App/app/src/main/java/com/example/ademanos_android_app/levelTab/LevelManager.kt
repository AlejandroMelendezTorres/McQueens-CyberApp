package com.example.ademanos_android_app.levelTab

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.example.ademanos_android_app.models.Quiz

@Composable
fun LevelManager(
    quiz: Quiz,
    modifier: Modifier = Modifier
){
    var currentLevel by remember { mutableStateOf(0) }
    var popupControl by remember { mutableStateOf(false) }
    var correctAnswer by remember { mutableStateOf (false)}
    var popupText by remember { mutableStateOf ("Respuesta incorrecta")}
    var popupButtonText by remember { mutableStateOf ("Intentar de nuevo")}

    Column(modifier = modifier) {
        Surface(
            modifier= Modifier
        ) {
            LevelTab(quiz.title,
                quiz.questions[currentLevel],
                { result ->
                    if (result == true){
                        if (currentLevel==quiz.questions.size-1){
                            /*TODO: MARK LEVEL AS COMPLETE AND RETURN TO LEVEL SELECTION*/
                        }
                        correctAnswer = true
                        popupText = "Respuesta Correcta"
                        popupButtonText = "Continuar"
                    }
                    popupControl=true
                },
                Modifier)
        }
    }
    if (popupControl) {
        PopupWindowDialog (
            { result ->
                if (result != null) {
                    popupControl = result
                    if (correctAnswer){
                        currentLevel += 1
                        correctAnswer=false
                        popupText = "Respuesta incorrecta"
                        popupButtonText = "Intentar de nuevo"
                    }
                }
            },
            popupText,
            popupButtonText)
    }
}


@Composable
fun PopupWindowDialog(
    result: (result: Boolean?) -> Unit,
    title: String,
    buttonMessage: String
) {
    Popup(
        alignment = Alignment.BottomCenter,
        onDismissRequest = { result.invoke(false) }
    ) {
        Surface(
            modifier = Modifier
                .height(280.dp)
                .width(370.dp)
                .offset(0.dp, (-12).dp),
            shape = RoundedCornerShape(12.dp),
            color = MaterialTheme.colorScheme.onPrimaryContainer
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 20.dp)
            ) {
                Text(
                    text = title.uppercase(),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.primaryContainer
                )
                Spacer(modifier = Modifier.height(60.dp))
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    onClick = { result.invoke(false) }
                ) {
                    Text(
                        text = buttonMessage,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}