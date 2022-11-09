package com.example.ademanos_android_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.ademanos_android_app.levelTab.LevelManager
import com.example.ademanos_android_app.profileTab.ProfileTab
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
                    val dictionaryTabScreen= BottomNavScreen("Dictionary Tab",R.drawable.book_solid
                    ) {  }

                    val levelTabScreen= BottomNavScreen("Level Tab",R.drawable.gamepad_solid
                    ) { LevelManager(TEST_QUIZ) }

                    val profileTabScreen= BottomNavScreen("Profile Tab",R.drawable.user_solid
                    ) { ProfileTab() }

                    val screens = listOf(dictionaryTabScreen,levelTabScreen,profileTabScreen)
                    BottomNavigation(screens)
                }
            }
        }
    }
}

data class BottomNavScreen(
    val label: String,
    @DrawableRes val icon: Int,
    val component: @Composable () -> Unit
)