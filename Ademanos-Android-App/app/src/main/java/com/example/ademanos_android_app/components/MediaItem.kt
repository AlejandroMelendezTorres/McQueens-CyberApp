package com.example.ademanos_android_app.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

@Composable
fun MediaItem(
    media: String,
    modifier: Modifier = Modifier
) {
    if (isVideo(media)){
        VideoPlayer(media, modifier)
    }
    else {
        AsyncImage(
            model = media,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = modifier
                .height(310.dp)
                .width(380.dp)
        )
    }
}

@Composable
fun VideoPlayer(
    VideoUrl: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        val context = LocalContext.current

        // create our player
        val exoPlayer = remember {
            ExoPlayer.Builder(context).build().apply {
                this.prepare()
            }
        }
        val mediaItem = MediaItem.fromUri(VideoUrl)
        exoPlayer.setMediaItem(mediaItem)

        // Implementing ExoPlayer
        AndroidView(
            modifier = Modifier
                .height(310.dp)
                .width(380.dp),
            factory = { context ->
                StyledPlayerView(context).apply {
                    player = exoPlayer
                }
            })
    }
}

fun isVideo(media:String): Boolean{
    if (media.contains("mp4", ignoreCase = true)
        || media.contains("m4v", ignoreCase = true)
    ){
        return true
    }
    return false
}