package com.example.ademanos_android_app.loginScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ademanos_android_app.R
import com.example.ademanos_android_app.components.AdemanosButton
import com.example.ademanos_android_app.components.AdemanosTextField

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier
            .padding(horizontal = 18.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.hand
            ),
            contentDescription = "Logo App",
        )
        Spacer(modifier = Modifier.height(5.1.dp))
        Text(stringResource(id = R.string.app_title), style = MaterialTheme.typography.titleLarge)
        AdemanosTextField(
            value = loginViewModel.email,
            onValueChange = { loginViewModel.onEmailChange(it) },
            placeholder = stringResource(id = R.string.email_field_label),
            isError = !loginViewModel.emailValid,
            enabled = !loginViewModel.loading,
            supportingText = {
                if (!loginViewModel.emailValid) {
                    Text(stringResource(id = R.string.email_supporting_text))
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        AdemanosTextField(
            value = loginViewModel.password,
            onValueChange = { loginViewModel.onPasswordChange(it) },
            placeholder = stringResource(id = R.string.password_field_label),
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            isError = !loginViewModel.passwordValid,
            enabled = !loginViewModel.loading,
            supportingText = {
                if (!loginViewModel.passwordValid) {
                    Text(stringResource(id = R.string.password_supporting_text))
                }
            }
        )
        Spacer(modifier = Modifier.height(15.dp))
        AdemanosButton(
            onClick = {
            loginViewModel.onLogin()
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = loginViewModel.buttonEnabled && !loginViewModel.loading,
        ) {
            if (loginViewModel.loading) {
                Text(stringResource(id = R.string.loading_label))
            } else {
                Text(stringResource(id = R.string.login_button_label))
            }
        }
    }
}