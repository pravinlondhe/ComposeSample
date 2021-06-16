package com.prl.android.composesample.animation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun PreviewCircularProgress() {
    DrawProgressBar(
        percentage = 0.80f,
        number = 1000
    )
}

@Composable
fun DrawProgressBar(
    modifier: Modifier = Modifier,
    percentage: Float,
    radius: Int = 50,
    strokeWidth: Dp = 8.dp,
    strokeColor: Color = Color.Green,
    textSize: TextUnit = 18.sp,
    animDuration: Int = 10000,
    number: Int,
    startAngle: Float = -45f
) {
    var animPlayed by remember {
        mutableStateOf(false)
    }

    val currentPercentage = animateFloatAsState(
        targetValue = if (animPlayed) percentage else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = 1000
        )
    )

    LaunchedEffect(key1 = true) {
        animPlayed = true
    }

    Box(
        modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.size(Dp(3f * radius)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Canvas(modifier = Modifier.fillMaxSize()) {
                drawArc(
                    color = strokeColor,
                    startAngle = startAngle,
                    sweepAngle = 360f * currentPercentage.value,
                    useCenter = false,
                    style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
                )
            }
        }

        Text(
            text = (number * currentPercentage.value).toInt().toString(),
            fontSize = textSize,
            fontWeight = FontWeight.Bold
        )
    }
}