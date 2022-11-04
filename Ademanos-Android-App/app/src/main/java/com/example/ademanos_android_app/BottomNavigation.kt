package com.example.ademanos_android_app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigation(
    screens: List<BottomNavScreen>,
    modifier: Modifier = Modifier
) {
    var selectedScreen by remember { mutableStateOf(0) }
    Column(modifier = modifier) {
        Surface(
            modifier= Modifier
        ) {
            screens[selectedScreen].component()
        }
        NavigationBar(
            modifier= Modifier
        ){
            for (i in screens.indices) {
                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = painterResource(screens[i].icon),
                            tint = MaterialTheme.colorScheme.onPrimaryContainer,
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                        )
                    },
                    onClick = { selectedScreen = i },
                    selected = selectedScreen==i
                )
            }
        }
    }
}