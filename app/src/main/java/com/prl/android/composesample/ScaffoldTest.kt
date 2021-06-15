package com.prl.android.composesample

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.DoubleArrow
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.rounded.Download
import androidx.compose.material.icons.rounded.Downloading
import androidx.compose.material.icons.rounded.Earbuds
import androidx.compose.material.icons.rounded.EditLocation
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun TestScaffoldTemplate() {
    val scaffoldState =
        rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    var bottomItemSelected by remember {
        mutableStateOf(1)
    }
    val coroutineScope = rememberCoroutineScope()
    Scaffold(topBar = {
        TopAppBar(elevation = 8.dp,
            title = {
                Text("Heading")
            },
            navigationIcon = {
                Icon(
                    Icons.Default.DoubleArrow,
                    contentDescription = "",
                    Modifier.clickable {
                        coroutineScope.launch {
                            if (DrawerValue.Closed == scaffoldState.drawerState.currentValue) {
                                scaffoldState.drawerState.open()
                            } else {
                                scaffoldState.drawerState.close()
                            }
                        }
                    }
                )
            },
            actions = {
                Icon(Icons.Default.Image, "")
                Spacer(modifier = Modifier.width(16.dp))
                Icon(Icons.Default.AccessTime, "")
                Spacer(modifier = Modifier.width(16.dp))
            }
        )
    },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.07f)
                    .background(Color.Yellow),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // first Item
                BottomNavigationItem(
                    selected = bottomItemSelected == 1,
                    onClick = { bottomItemSelected = 1 },
                    icon = { Icon(Icons.Rounded.Downloading, "") },
                    label = {
                        Text("Item1")
                    },
                    selectedContentColor = Color.Red,
                    unselectedContentColor = Color.Black
                )

                // second Item
                BottomNavigationItem(
                    selected = bottomItemSelected == 2,
                    onClick = { bottomItemSelected = 2 },
                    icon = { Icon(Icons.Rounded.Earbuds, "") },
                    label = {
                        Text("Item2")
                    },
                    selectedContentColor = Color.Red,
                    unselectedContentColor = Color.Black
                )

                // Third Item
                BottomNavigationItem(
                    selected = bottomItemSelected == 3,
                    onClick = { bottomItemSelected = 3 },
                    icon = { Icon(Icons.Rounded.EditLocation, "") },
                    label = {
                        Text("Item3")
                    },
                    selectedContentColor = Color.Red,
                    unselectedContentColor = Color.Black
                )

                // Fourth Item
                BottomNavigationItem(
                    selected = bottomItemSelected == 4,
                    onClick = { bottomItemSelected = 4 },
                    icon = { Icon(Icons.Rounded.Download, "") },
                    label = {
                        Text("Item4")
                    },
                    selectedContentColor = Color.Red,
                    unselectedContentColor = Color.Black
                )

            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Floating button clicked")
                    }
                },
                backgroundColor = Color.Blue,

                ) {
                Text("+", color = Color.White)
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        scaffoldState = scaffoldState,
        drawerContent = {
            for (i in 1..4) {
                Text("Item $i")
            }
        }) {

    }
}
