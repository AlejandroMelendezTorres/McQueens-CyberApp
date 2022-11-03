package com.example.ademanos_android_app.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ademanos_android_app.R

@Composable
fun BottomNavigation(
    selected: Int,
    modifier: Modifier = Modifier
) {
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
            selected = selected==1,
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
            selected = selected==2,
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
            selected = selected==3,
            onClick = { /*TODO*/ }
        )
    }
}