package com.example.ademanos_android_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ademanos_android_app.levelTab.LevelTab
import com.example.ademanos_android_app.models.Question
import com.example.ademanos_android_app.ui.theme.AdemanosAndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdemanosAndroidAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val testQuestion = Question(
                        "test",
                        TEST_VIDEO,
                        "¿Qué numero es este?",
                        arrayOf("1","2","3","4"),
                        1
                    )
                    LevelTab(
                        "Nivel 1",
                        testQuestion
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AdemanosAndroidAppTheme {
        Greeting("Android")
    }
}