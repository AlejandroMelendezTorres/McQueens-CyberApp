package com.example.ademanos_android_app.profileTab

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ademanos_android_app.AppViewModel
import md_theme_light_checkedTrack
import md_theme_light_onSurfaceVariant
import md_theme_light_outline
import md_theme_light_primary

@Composable
fun ProfileTab(
    modifier: Modifier = Modifier,
    appViewModel: AppViewModel = hiltViewModel()
){
    val user by appViewModel.currentUser.collectAsState(initial = null)

    if (user == null){
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CircularProgressIndicator()
        }
    }
    else {
        Column(modifier = modifier) {
            Text(
                text = "Perfil",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Left,
                color =  MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp),
            )
            Row(modifier = Modifier) {
                Spacer(modifier = Modifier.width(13.dp))
                Text(
                    text = "BIENVENID@",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.padding(vertical = 2.dp, horizontal = 6.dp),
                )
            }

            Text(
                text = user!!.username,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Left,
                color =  MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(vertical = 2.dp, horizontal = 20.dp),
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = user!!.email,
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center,
                color =  MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(vertical = 2.dp, horizontal = 20.dp),
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier) {
                Spacer(modifier = Modifier.width(17.dp))
                Icon(
                    painter = painterResource(id =  com.example.ademanos_android_app.R.drawable.graph),
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(vertical = 5.dp)
                )
                Text(
                    text = "NIVELES COMPLETADOS",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.padding(vertical = 2.dp, horizontal = 6.dp),
                )
            }
            Row(modifier = Modifier) {
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = user!!.completedLevels.toString(),
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Left,
                    color =  MaterialTheme.colorScheme.onPrimaryContainer,
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "niveles",
                    style = MaterialTheme.typography.titleSmall,
                    textAlign = TextAlign.Center,
                    color =  MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(vertical = 11.dp)
                )
            }
            Row(modifier = Modifier) {
                Spacer(modifier = Modifier.width(17.dp))
                Icon(
                    painter = painterResource(id =  com.example.ademanos_android_app.R.drawable.square_check),
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    contentDescription = null,
                    modifier = Modifier
                        .size(31.dp)
                        .padding(vertical = 5.dp)
                )
                Text(
                    text = "PALABRAS CONSULTADAS",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.padding(vertical = 2.dp, horizontal = 6.dp),
                )
            }
            Row(modifier = Modifier) {
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = user!!.consultedWords.toString(),
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Left,
                    color =  MaterialTheme.colorScheme.onPrimaryContainer,
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "palabras",
                    style = MaterialTheme.typography.titleSmall,
                    textAlign = TextAlign.Center,
                    color =  MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(vertical = 11.dp)
                )
            }
            Spacer(modifier = Modifier.width(25.dp))
            Text(
                text = "Configuración",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Left,
                color =  MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp),
            )
            Row(modifier = Modifier) {
                Text(
                    text = "Notificaciones",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.padding(vertical = 13.5.dp, horizontal = 20.dp),
                )
                val checkedState = remember { mutableStateOf(true) }
                Switch(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = !checkedState.value },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = md_theme_light_primary,
                        uncheckedThumbColor = md_theme_light_onSurfaceVariant,
                        checkedTrackColor = md_theme_light_checkedTrack,
                        uncheckedTrackColor = md_theme_light_outline
                    )

                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.tertiary
                    ),
                    modifier = Modifier.padding(vertical = 30.dp),
                    shape = RoundedCornerShape(12.dp),
                    onClick = {appViewModel.onSignOut()}
                ) {
                    Text(
                        text = "CERRAR SESIÓN",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}