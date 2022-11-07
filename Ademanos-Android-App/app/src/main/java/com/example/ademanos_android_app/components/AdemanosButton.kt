package com.example.ademanos_android_app.components

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ademanos_android_app.ui.theme.AdemanosAndroidAppTheme

@Composable
fun AdemanosButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    content: @Composable () -> Unit,
) {
    ElevatedButton(
        modifier = modifier,
        onClick = onClick,
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),
        enabled = enabled
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun AdemanosButtonPreview() {
    AdemanosAndroidAppTheme {
        AdemanosButton(modifier = Modifier, onClick = { /*TODO*/ }) {
            Text("Button")
        }
    }
}
