package com.prl.android.composesample

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun ListUsingColumn() {
    val scrollableState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollableState)
    ) {
        for (i in 1..50) {
            MyListItem(i = i)
        }
    }
}


@Composable
fun ListUsingLazyColumn() {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(100) {
            MyListItem(i = it)
        }
    }
}

@Composable
fun MyListItem(i: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(Random.nextInt())),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                modifier = Modifier
                    .size(60.dp)
                    .padding(8.dp)
                    .clip(CircleShape),
                painter = painterResource(id = if (i % 2 == 0) R.drawable.ima else R.drawable.facepaint),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Item $i",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}