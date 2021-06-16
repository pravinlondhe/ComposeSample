package com.prl.android.composesample

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter

@OptIn(ExperimentalAnimationApi::class)
@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun LoadRemoteImage() {
    var imageVisibility by remember {
        mutableStateOf(true)
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedVisibility(visible = imageVisibility) {
                Image(
                    painter = rememberCoilPainter(
                        request = "https://3.bp.blogspot.com/-VVp3WvJvl84/X0Vu6EjYqDI/AAAAAAAAPjU/ZOMKiUlgfg8ok8DY8Hc-ocOvGdB0z86AgCLcBGAsYHQ/s1600/jetpack%2Bcompose%2Bicon_RGB.png"
                    ),
                    contentDescription = "Compose image",
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
            Button(
                onClick = {
                    imageVisibility = imageVisibility.not()
                }
            ) {
                Text(text = "Click Me")
            }
        }
    }
}