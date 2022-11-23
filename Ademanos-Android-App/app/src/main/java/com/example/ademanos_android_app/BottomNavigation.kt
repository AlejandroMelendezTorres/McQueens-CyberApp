package com.example.ademanos_android_app

import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigation(
    screens: List<BottomNavScreen>,
    onSelected: (i: Int) -> Unit,
    selected: Int,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        for (i in screens.indices) {
            if (screens[i].hidden) continue
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
                onClick = { onSelected(i) },
                selected = selected == i,
                modifier = Modifier.semantics { testTag = screens[i].label }
            )
        }
    }
}