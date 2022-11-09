package com.example.ademanos_android_app.profileTab

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ademanos_android_app.ui.theme.AdemanosAndroidAppTheme
import md_theme_light_checkedTrack
import md_theme_light_onSurfaceVariant
import md_theme_light_outline
import md_theme_light_primary


//class ProfileTab : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            AdemanosAndroidAppTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Greeting("Android")
//                }
//            }
//        }
//    }
//}

@Composable
fun ProfileTab(
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
        Text(
            text = "Perfil",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Left,
            color =  MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp),
        )
        Text(
            text = "TIEMPO TOTAL APRENDIENDO",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 20.dp),
        )
        Row(modifier = Modifier) {
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "10",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Left,
                color =  MaterialTheme.colorScheme.onPrimaryContainer,
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "horas",
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center,
                color =  MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(vertical = 11.dp)
            )
        }
        Text(
            text = "NIVELES COMPLETADOS",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 20.dp),
        )
        Row(modifier = Modifier) {
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "3",
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
        Text(
            text = "PALABRAS CONSULTADAS",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 20.dp),
        )
        Row(modifier = Modifier) {
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "5",
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
//            var placeHolderN: Boolean
//            Spacer(modifier = Modifier.width(20.dp))
            Switch(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = false },
//                modifier = Modifier.padding(vertical = 10.dp)
                colors = SwitchDefaults.colors(
                    checkedThumbColor = md_theme_light_primary,
                    uncheckedThumbColor = md_theme_light_onSurfaceVariant,
                    checkedTrackColor = md_theme_light_checkedTrack,
                    uncheckedTrackColor = md_theme_light_outline
                )
            )
        }
//        Spacer(modifier = Modifier.width(50.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiary
                ),
                modifier = Modifier.padding(vertical = 30.dp),
                shape = RoundedCornerShape(12.dp),
                onClick = { /*TODO: Session Log Out*/ }
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


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AdemanosAndroidAppTheme {
        ProfileTab(Modifier)
    }
}