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
            TestState()
//            TextStyle()
//            NewsStory()
//            CardFacepaint(painter = painterResource(id = R.drawable.facepaint), title = "Joker is here", contentDesc = "Joker is here")
        }
    }

    @Composable
    fun Greetings() {
        Text(GREETING, color = Color.Cyan)
    }

    @Preview
    @Composable
    fun NewsStory() {
        Row(
            modifier = Modifier
                .padding(Dp(8f))
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
                Text("heading",fontSize = 18.sp, )
                Text("Body", modifier = Modifier.padding(top = 8.dp, bottom = 8.dp), fontSize = 14.sp)
                Text("Message Message Message \n Message Message Message Message")
                Text("End lines End lines End lines")
            }
        }
    }

    companion object {
        const val GREETING = "Hello Compose world"
    }
}




