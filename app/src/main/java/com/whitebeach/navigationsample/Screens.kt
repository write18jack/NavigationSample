package com.whitebeach.navigationsample

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.whitebeach.navigationsample.bottom.BottomNavBar
import com.whitebeach.navigationsample.bottom.BottomNavHost
import com.whitebeach.navigationsample.bottom.BottomNavItem
import com.whitebeach.navigationsample.ui.theme.NavigationSampleTheme

@Preview
@Composable
fun Content1Preview() {
    NavigationSampleTheme {
        Content1()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content1() {
    Surface(
        Modifier
            .fillMaxSize()
            .background(Color.Red)) {
        Text(text = "Content1")
//        val navController = rememberNavController()
//        val currentBackStack by navController.currentBackStackEntryAsState()
//
//        val screens = listOf(
//            Content2.apply {
//                onClickTopBarIcon = {
//                   // navController.popBackStack(Content1.route, false)
//                }
//                onClickActionsIcon = {
//                    navController.navigate(Content3.route)
//                }
//            },
//            Content3.apply {
//                onClickTopBarIcon = {
//                    navController.popBackStack(Content2.route, false)
//                }
//            }
//        )

//        Scaffold(
//            topBar = {
//                screens
//                    .find { it.route == currentBackStack?.destination?.route }
//                    ?.let {
//                        TopAppBar(
//                            title = it.topBarTitle,
//                            navigationIcon = it.navigationIcon,
//                            actions = it.actionsIcon,
//                            colors = TopAppBarDefaults.mediumTopAppBarColors(
//                                containerColor = Color.Blue,
//                                navigationIconContentColor = Color.White,
//                                titleContentColor = Color.White,
//                                actionIconContentColor = Color.White
//                            )
//                        )
//                    }
//            },
//            bottomBar = {
//
//            }
//        ) {
//            NavHost(
//                navController = navController,
//                startDestination = Content2.route,
//                Modifier.padding(it)
//            ) {
//                composable(Content2.route) {
//                    Content2(navController = navController)
//                }
//                composable(Content3.route) {
//                    Content3(navController = navController)
//                }
//                composable(Content4.route) {
//
//                }
//            }
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content4() {

    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(
//                        text = "テンプレート"
//                    )
//                },
//                colors = TopAppBarDefaults.mediumTopAppBarColors(
//                    containerColor = Color.Blue,
//                    titleContentColor = Color.White,
//                )
//            )
//        }
    ) {
        Box(
            Modifier
                .padding(it)
                .fillMaxSize()
                .background(Color.Red)
        ) {
            Text(text = "Content4")
        }
    }
}
