package com.example.ademanos_android_app.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.ademanos_android_app.ui.theme.AdemanosAndroidAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdemanosTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    placeholder: String,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    supportingText: (@Composable () -> Unit)? = null
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        label = {
            Text(text = placeholder.uppercase(), fontWeight = FontWeight.Bold)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        isError = isError,
        visualTransformation = visualTransformation,
        supportingText = supportingText
    )
}

@Preview
@Composable
fun AdemanosTextFieldPreview() {
    AdemanosAndroidAppTheme() {
        AdemanosTextField(value = "2", onValueChange = {}, placeholder = "Text Field")
    }
}