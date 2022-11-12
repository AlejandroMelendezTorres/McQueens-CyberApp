package com.example.ademanos_android_app.cardGrid

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ademanos_android_app.components.ButtonCard
import com.example.ademanos_android_app.components.NavigationManager
import com.example.ademanos_android_app.models.CardGridElement

@Composable
fun CardGrid(
    modifier: Modifier = Modifier,
    title: String,
    data: List<CardGridElement>,
    nextScreen: Int
) {
    Column(modifier = modifier.padding(horizontal = 18.dp).fillMaxSize()) {
        Text(title, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(5.1.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            itemsIndexed(data) { i, item ->
                ButtonCard(
                    text = item.getDisplayTitle(),
                    color = if (i % 2 == 0) {
                        MaterialTheme.colorScheme.primary
                    } else MaterialTheme.colorScheme.onPrimaryContainer
                ) {
                    NavigationManager.navigate(nextScreen, item)
                }
            }
        }
    }
}