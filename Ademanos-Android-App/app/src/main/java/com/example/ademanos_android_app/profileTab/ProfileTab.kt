package com.example.ademanos_android_app.profileTab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ademanos_android_app.components.MediaItem
import com.example.ademanos_android_app.levelTab.OptionCardGrid
import com.example.ademanos_android_app.models.Question
import com.example.ademanos_android_app.ui.theme.AdemanosAndroidAppTheme

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
        androidx.compose.material3.Text(
            text = "Perfil",
            style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Left,
            color =  androidx.compose.material3.MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp),
        )
        androidx.compose.material3.Text(
            text = "TIEMPO TOTAL APRENDIENDO",
            style = androidx.compose.material3.MaterialTheme.typography.labelSmall,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 20.dp),
        )
        Row(modifier = Modifier) {
            Spacer(modifier = Modifier.width(20.dp))
            androidx.compose.material3.Text(
                text = "10",
                style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
                // style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Left,
                color =  androidx.compose.material3.MaterialTheme.colorScheme.onPrimaryContainer,
            )
//            Spacer(modifier = Modifier.width(8.dp))
            androidx.compose.material3.Text(
                text = "horas",
                style = androidx.compose.material3.MaterialTheme.typography.titleSmall,
                // style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                color =  androidx.compose.material3.MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(vertical = 11.dp)
            )
        }
        androidx.compose.material3.Text(
            text = "NIVELES COMPLETADOS",
            style = androidx.compose.material3.MaterialTheme.typography.labelSmall,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 20.dp),
        )
        Row(modifier = Modifier) {
            Spacer(modifier = Modifier.width(20.dp))
            androidx.compose.material3.Text(
                text = "3",
                style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
                // style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Left,
                color =  androidx.compose.material3.MaterialTheme.colorScheme.onPrimaryContainer,
            )
//            Spacer(modifier = Modifier.width(8.dp))
            androidx.compose.material3.Text(
                text = "niveles",
                style = androidx.compose.material3.MaterialTheme.typography.titleSmall,
                // style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                color =  androidx.compose.material3.MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(vertical = 11.dp)
            )
        }
        androidx.compose.material3.Text(
            text = "PALABRAS CONSULTADAS",
            style = androidx.compose.material3.MaterialTheme.typography.labelSmall,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 20.dp),
        )
        Row(modifier = Modifier) {
            Spacer(modifier = Modifier.width(20.dp))
            androidx.compose.material3.Text(
                text = "5",
                style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
                // style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Left,
                color =  androidx.compose.material3.MaterialTheme.colorScheme.onPrimaryContainer,
            )
//            Spacer(modifier = Modifier.width(8.dp))
            androidx.compose.material3.Text(
                text = "palabras",
                style = androidx.compose.material3.MaterialTheme.typography.titleSmall,
                // style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                color =  androidx.compose.material3.MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(vertical = 11.dp)
            )
        }
        Spacer(modifier = Modifier.width(25.dp))

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AdemanosAndroidAppTheme {
        ProfileTab(Modifier)
    }
}