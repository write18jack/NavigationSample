package com.whitebeach.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.whitebeach.navigationsample.bottom.BottomNavBar
import com.whitebeach.navigationsample.bottom.BottomNavHost
import com.whitebeach.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationSampleTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ParentContent()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParentContent() {
    Surface {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        val title = remember { mutableStateOf("Content 1") }
        var x by remember { mutableStateOf(true) }

        val screensX = listOf(
            Content2.apply {
                onClickTopBarIcon = {
                    // navController.popBackStack(Content1.route, false)
                }
                onClickActionsIcon = {
                    navController.navigate(Content3.route)
                }
            },
            Content3.apply {
                onClickTopBarIcon = {
                    navController.popBackStack(Content2.route, false)
                }
            }
        )
        screensX.forEach { _ ->
            x = (currentDestination?.hierarchy?.any { it.route == "content1" } == true)
        }

        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text(text = title.value) },
                    navigationIcon = {
                        if (x) {
                            IconButton(onClick = { navController.navigate(Content2.route)}) {
                                Icon(
                                    imageVector = Icons.Default.Settings,
                                    contentDescription = null
                                )
                            }
                        }
                    },
                    actions = {
                        if (x) {
                            IconButton(onClick = {
                                navController.navigate(Content3.route)
                            }) {
                                Icon(imageVector = Icons.Default.Check, contentDescription = null)
                            }
                        }
                    },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Gray)
                )
//                screensX
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
            },
            bottomBar = {
                BottomNavBar(
                    navController,
                    onNavigateToDestination = {
                        title.value = it
                    }
                )
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = Content1.route,
                Modifier.padding(it)
            ) {
                composable(Content1.route) {
                    Content1()
                }
                composable(Content2.route) {
                    Content2(navController = navController)
                }
                composable(Content3.route) {
                    Content3(navController = navController)
                }
                composable(Content4.route) {
                    Content4()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationSampleTheme {
        ParentContent()
    }
}