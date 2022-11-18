package com.example.ademanos_android_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.ademanos_android_app.profileTab.ProfileTab
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ademanos_android_app.cardGrid.CategoryScreen
import com.example.ademanos_android_app.cardGrid.DictionaryScreen
import com.example.ademanos_android_app.cardGrid.QuizzScreen
import com.example.ademanos_android_app.components.NavigationManager
import com.example.ademanos_android_app.levelTab.LevelScreen
import com.example.ademanos_android_app.loginScreen.LoginScreen
import com.example.ademanos_android_app.ui.theme.AdemanosAndroidAppTheme
import dagger.hilt.android.AndroidEntryPoint
import com.example.ademanos_android_app.wordView.WordView

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdemanosApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdemanosApp(appViewModel: AppViewModel = hiltViewModel()) {
    AdemanosAndroidAppTheme {
        val user by appViewModel.currentUser.collectAsState(initial = null)
        val dictionaryTabScreen = BottomNavScreen(
            "Dictionary Tab", R.drawable.book_solid
        ) { DictionaryScreen() }

        val quizTabScreen = BottomNavScreen(
            "Quiz Tab",
            R.drawable.gamepad_solid
        ) { QuizzScreen() }

        val levelTabScreen = BottomNavScreen(
            "Level Tab",
            R.drawable.gamepad_solid,
            true
        ) { LevelScreen() }

        val profileTabScreen = BottomNavScreen(
            "Profile Tab", R.drawable.user_solid
        ) {
            if (user == null) {
                LoginScreen()
            } else if (user!!.id == "loading") {
                Text(text = "User is loading")
            } else {
                ProfileTab()
            }
        }

        val categoryTabScreen = BottomNavScreen(
            "Category tab",
            R.drawable.book_solid,
            true,
        ) {
            CategoryScreen()
        }

        val wordTabScreen = BottomNavScreen(
            "Word tab",
            R.drawable.book_solid,
            true,
        ) {
            WordView()
        }
        
        val screens = listOf(dictionaryTabScreen, quizTabScreen, profileTabScreen, categoryTabScreen, wordTabScreen,levelTabScreen)
        Scaffold(
            bottomBar = {
                BottomNavigation(
                    screens = screens,
                    onSelected = { i -> NavigationManager.navigate(i, null) },
                    selected = appViewModel.selectedScreen
                )
            },
            snackbarHost = {
                SnackbarHost(hostState = appViewModel.snackbarHostState) { data ->
                    Snackbar(
                        modifier = Modifier.padding(12.dp),
                        shape = CutCornerShape(4.dp),
                        containerColor = MaterialTheme.colorScheme.secondary,
                        action = {
                            TextButton(
                                onClick = { data.dismiss() },
                                colors = ButtonDefaults
                                    .textButtonColors(contentColor = MaterialTheme.colorScheme.onError)
                            ) {
                                Text("Ok")
                            }
                        }
                    ) {
                        Text(data.visuals.message)
                    }
                }
            }
        ) { padding ->
            screens[appViewModel.selectedScreen].component(Modifier.padding(padding))
        }
    }
}

data class BottomNavScreen(
    val label: String,
    @DrawableRes val icon: Int,
    val hidden: Boolean = false,
    val component: @Composable (Modifier) -> Unit,
)