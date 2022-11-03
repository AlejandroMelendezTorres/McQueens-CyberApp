package com.example.ademanos_android_app.levelTab

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.unit.dp

@Composable
fun OptionCard(
    text: String,
    color: Color,
    index: Int,
    onclick: () -> Unit,
    modifier: Modifier = Modifier
){
    Button(
        onClick = onclick,
        modifier= modifier
            .height(84.dp)
            .width(170.dp),
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