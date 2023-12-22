package com.whitebeach.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.whitebeach.navigationsample.bottom.BottomNavBar
import com.whitebeach.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationSampleTheme {
                // A surface container using the 'background' color from the theme
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
        val currentBackStack by navController.currentBackStackEntryAsState()

        val screens = listOf(
            Content1.apply {
                onClickActionsIcon = {
                    navController.navigate(Content2.route)
                }
            },
            Content2.apply {
                onClickTopBarIcon = {
                    navController.popBackStack(Content1.route, false)
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

        Scaffold(
            topBar = {
                screens
                    .find { it.route == currentBackStack?.destination?.route }
                    ?.let {
                        it.navigationIcon?.let { it1 ->
                            it.actionsIcon?.let { it2 ->
                                TopAppBar(
                                    title = it.topBarTitle,
                                    navigationIcon = it1,
                                    actions = it2,
                                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                                        containerColor = Color.Blue,
                                        navigationIconContentColor = Color.White,
                                        titleContentColor = Color.White,
                                        actionIconContentColor = Color.White
                                    )
                                )
                            }
                        }
                    }
            },
            bottomBar = {
                BottomNavBar(navController)
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = Content1.route,
                Modifier.padding(it)
            ) {
                composable(Content1.route) {
                    Content1(navController)
                }
                composable(Content2.route) {
                    Content2(navController = navController)
                }
                composable(Content3.route){
                    Content3(navController = navController)
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