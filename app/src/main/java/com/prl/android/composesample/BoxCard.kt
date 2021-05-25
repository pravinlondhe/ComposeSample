package com.prl.android.composesample

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CardFacepaint(
    painter: Painter,
    title: String,
    contentDesc: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(0.5f)
            .fillMaxHeight(0.3f),
        elevation = 4.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(modifier = modifier.fillMaxSize()) {
            Image(
                painter = painter,
                contentDescription = contentDesc,
                contentScale = ContentScale.FillBounds
            )
        }
        Box(
            modifier = Modifier.background(
                Brush.verticalGradient(
                    listOf(Color.Transparent, Color.Black),
                    300f
                )
            )
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(text = title, color = Color.White, fontSize = 20.sp)
        }
    }
}