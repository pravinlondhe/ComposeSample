package com.prl.android.composesample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun TestState() {
    var color by remember {
        mutableStateOf(Color.Yellow)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = color)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                onClick = {
                    color = Color(
                        Random.nextInt(),
                        Random.nextInt(),
                        Random.nextInt()
                    )
                }) {
                Text(
                    text = "Change Color",
                    fontSize = 16.sp
                )
            }
        }
    }
}