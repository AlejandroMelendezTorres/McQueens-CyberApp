package com.example.ademanos_android_app.levelTab

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ademanos_android_app.QUIZ_TAB
import com.example.ademanos_android_app.R
import com.example.ademanos_android_app.components.AdemanosButton
import com.example.ademanos_android_app.components.NavigationManager
import com.example.ademanos_android_app.components.SnackbarManager
import com.example.ademanos_android_app.models.Quiz

@Composable
fun LevelScreen(
    modifier: Modifier = Modifier,
    levelViewModel: LevelViewModel = hiltViewModel()
){
    DisposableEffect(key1 = levelViewModel) {
        levelViewModel.onStart()
        onDispose { levelViewModel.onStop() }
    }

    if (levelViewModel.loading) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CircularProgressIndicator()
        }
    } else if (levelViewModel.hasError) {
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
            AdemanosButton(onClick = { levelViewModel.onStart() }) {
                Text(stringResource(id = R.string.retry))
            }
        }
    } else {
        val quiz = (NavigationManager.args as Quiz)
        Column(modifier = modifier
            .fillMaxSize(),
        ) {
            Surface(
                modifier= Modifier
            ) {
                LevelCard(
                    quiz.title,
                    quiz.questions[levelViewModel.currentLevel],
                    { result ->
                        if (result != null) {
                            val finishedLevel = levelViewModel.evaluateQuizResult(result,quiz.questions.size)
                            if (finishedLevel){
                                /*TODO: MARK LEVEL AS COMPLETE IN DB*/
                                SnackbarManager.showMessage("Nivel completado")
                                levelViewModel.onStop()
                                NavigationManager.navigate(QUIZ_TAB,null)
                            }
                        }
                    },
                    Modifier
                )

                if (levelViewModel.popupControl) {
                    PopupWindowDialog (
                        result = { result ->
                            if (result != null) {
                                levelViewModel.evaluatePopupControl(result)
                            }
                        },
                        title = levelViewModel.popupText,
                        buttonMessage = levelViewModel.popupButtonText
                    )
                }
            }
        }
    }
}


@Composable
fun PopupWindowDialog(
    result: (result: Boolean?) -> Unit,
    title: String,
    buttonMessage: String,
    modifier: Modifier=Modifier
) {
    Popup(
        alignment = Alignment.BottomCenter,
        onDismissRequest = { result.invoke(false) }
    ) {
        Surface(
            modifier = modifier
                .height(250.dp)
                .width(370.dp),
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