package com.example.ademanos_android_app.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonCard(
    text: String,
    color: Color,
    modifier: Modifier = Modifier,
    onclick: () -> Unit,
){
    Button(
        onClick = onclick,
        modifier= modifier
            .height(60.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )
    ) {
        Box(
            contentAlignment= Alignment.Center,
            modifier= Modifier
        ){
            Text(
                text = text.uppercase(),
                textAlign= TextAlign.Center,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .wrapContentHeight()
            )
        }
    }
}

@Preview
@Composable
fun ButtonCardPreview() {
    ButtonCard(text = "números", color = MaterialTheme.colorScheme.primary) {

    }
}