package com.example.ademanos_android_app.wordView

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ademanos_android_app.components.MediaItem
import com.example.ademanos_android_app.components.NavigationManager
import com.example.ademanos_android_app.models.Word

@Composable
fun WordView(){
    if (NavigationManager.args is Word) {
        Column() {
            Text(
                text = (NavigationManager.args as Word).name,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Left,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                MediaItem((NavigationManager.args as Word).media, modifier = Modifier.padding(vertical = 10.dp))
            }
        }
    }
}