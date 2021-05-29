package com.prl.android.composesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestScaffold()
//            TestState()
//            TextStyle()
//            NewsStory()
//            CardFacepaint(painter = painterResource(id = R.drawable.facepaint), title = "Joker is here", contentDesc = "Joker is here")
        }
    }

    @Composable
    fun Greetings() {
        Text(GREETING, color = Color.Cyan)
    }

    companion object {
        const val GREETING = "Hello Compose world"
    }
}




