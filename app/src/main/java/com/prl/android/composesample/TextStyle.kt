package com.prl.android.composesample

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextStyle() {
    val fontFamily = FontFamily(
        fonts = listOf(
            Font(R.font.source_code_pro_back, FontWeight.Black),
            Font(R.font.source_code_pro_bold, FontWeight.Bold),
            Font(R.font.source_code_pro_regular, FontWeight.Normal),
            Font(R.font.source_code_pro_light, FontWeight.Light)
        )
    )

    val annotatedStr = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Red, fontSize = 28.sp)) {
            append("J")
        }
        append("aquine ")
        withStyle(style = SpanStyle(color = Color.Red, fontSize = 28.sp)) {
            append("P")
        }
        append("honix")
    }
    Row(
        modifier = Modifier
            .padding(Dp(8f))
            .background(Color.LightGray)
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.facepaint),
            null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp, 120.dp)
                .clip(
                    CircleShape
                )
        )
        Spacer(Modifier.size(16.dp))
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceEvenly) {
            Text(
                annotatedStr,
                fontSize = 22.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
            )
            Text(
                "Body",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp),
                fontSize = 16.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center,
            )
            Text(
                "Message Message Message Message Message Message Message",
                fontSize = 14.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal
            )
            Spacer(Modifier.size(16.dp))
            Text(
                "End lines End lines End lines",
                fontSize = 14.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Normal,
                textDecoration = TextDecoration.Underline
            )
        }
    }
}