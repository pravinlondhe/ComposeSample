package com.prl.android.composesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListUsingLazyRow()
//            ListUsingRow()
//            ListUsingLazyColumn()
//            ListUsingColumn()
//            TestScaffold()
//            TestState()
//            TextStyle()
//            NewsStory()
//            CardFacepaint(painter = painterResource(id = R.drawable.facepaint), title = "Joker is here", contentDesc = "Joker is here")
        }
    }

    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    fun Greetings() {
        Text(GREETING, color = Color.Cyan)
    }

    companion object {
        const val GREETING = "Hello Compose world"
    }
}




