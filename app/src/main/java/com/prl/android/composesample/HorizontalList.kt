package com.prl.android.composesample

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Preview(showBackground = true)
@Composable
fun ListUsingRow() {
    val scrollableState = rememberScrollState()
    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(scrollableState)
    ) {
        for (i in 1..10) {
            MyHorizontalListItem(i = i)
        }
    }
}


@Composable
fun ListUsingLazyRow() {
    LazyRow(modifier = Modifier.fillMaxHeight()) {
        items(20) {
            MyHorizontalListItem(i = it)
        }
    }
}

@Composable
fun MyHorizontalListItem(i: Int) {
    var selected by remember {
        mutableStateOf(false)
    }
    val cardBackgroundColor by animateColorAsState(
        targetValue = if (selected) Color.LightGray else Color.Transparent
    )

    val imageSize by animateDpAsState(
        targetValue = if (selected) 120.dp else 180.dp
    )
    Card(
        modifier = Modifier
            .fillMaxHeight(.35f)
            .background(cardBackgroundColor)
            .padding(8.dp)
            .clickable { selected = !selected },
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(Color(Random.nextInt())),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(imageSize)
                    .padding(8.dp)
                    .clip(CircleShape),
                painter = painterResource(id = if (i % 2 == 0) R.drawable.ima else R.drawable.facepaint),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Item $i"
            )
        }
    }
}