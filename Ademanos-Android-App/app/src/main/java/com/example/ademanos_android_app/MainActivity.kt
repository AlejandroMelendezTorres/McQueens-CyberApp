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
import com.example.ademanos_android_app.ui.theme.AdemanosAndroidAppTheme
import com.example.ademanos_android_app.ui.theme.QuizQuestion

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
                    var testQuestion = QuizQuestion(
                        1,
                        R.drawable.number_1,
                        "Test question", arrayOf<String>(
                            "Option 1","Option 2","Option 3","Option 4"
                        ),
                        "Option 1")
                    LevelTab(testQuestion)
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