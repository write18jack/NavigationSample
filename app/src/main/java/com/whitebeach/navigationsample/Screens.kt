package com.whitebeach.navigationsample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun Content1(
    navController: NavController
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(text = "Content1")
//        Button(onClick = { navController.navigate(Content2.route) }) {
//            Text(text = "PUSH")
//        }
    }
}

@Composable
fun Content2(
    navController: NavController
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Text("content2")
    }
}

@Composable
fun Content3(
    navController: NavController
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(text = "Content3")
    }
}

@Composable
fun Content4() {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(text = "Content4")
    }
}
