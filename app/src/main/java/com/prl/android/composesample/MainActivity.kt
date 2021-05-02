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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsStory()
        }
    }

    @Composable
    fun Greetings() {
        Text(GREETING, color = Color.Cyan)
    }

    @Preview
    @Composable
    fun NewsStory() {
        Column(
            modifier = Modifier
                .padding(Dp(8f))
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ima), null,
                contentScale = ContentScale.Inside, modifier = Modifier
                    .size(120.dp, 120.dp)
                    .clip(
                        CircleShape
                    ),
                alignment = Alignment.Center
            )
            Spacer(Modifier.height(16.dp))
            Row {
                Text("heading")
                Text("Body", modifier = Modifier.padding(start = 8.dp))
            }
            Text("Message Message Message \n Message Message Message Message")
            Text("End lines End lines End lines")
        }
    }

    companion object {
        const val GREETING = "Hello Compose world"
    }
}




