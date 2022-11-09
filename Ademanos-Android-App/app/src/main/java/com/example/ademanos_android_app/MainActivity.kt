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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ademanos_android_app.levelTab.LevelScreen
import com.example.ademanos_android_app.loginScreen.LoginScreen
import com.example.ademanos_android_app.profileTab.ProfileTab
import com.example.ademanos_android_app.ui.theme.AdemanosAndroidAppTheme

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
fun AdemanosApp(appViewModel: AppViewModel = viewModel()) {
    AdemanosAndroidAppTheme {
        val dictionaryTabScreen = BottomNavScreen(
            "Dictionary Tab", R.drawable.book_solid
        ) { }

        val levelTabScreen = BottomNavScreen(
            "Level Tab", R.drawable.gamepad_solid
        ) { LevelScreen(TEST_QUIZ) }

        val profileTabScreen = BottomNavScreen(
            "Profile Tab", R.drawable.user_solid
        ) { ProfileTab() }

        val screens = listOf(dictionaryTabScreen, levelTabScreen, profileTabScreen)
        Scaffold(
            bottomBar = {
                BottomNavigation(
                    screens = screens,
                    onSelected = { i -> appViewModel.selectScreen(i) },
                    selected = appViewModel.selectedScreen
                )
            },
            snackbarHost = {
                SnackbarHost(hostState = appViewModel.snackbarHostState) { data ->
                    Snackbar(
                        modifier = Modifier.padding(12.dp),
                        shape = CutCornerShape(4.dp),
                        containerColor = MaterialTheme.colorScheme.error,
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
    val component: @Composable (Modifier) -> Unit
)