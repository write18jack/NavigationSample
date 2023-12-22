package com.whitebeach.navigationsample.bottom

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.whitebeach.navigationsample.Content1
import com.whitebeach.navigationsample.Content4

@Composable
fun BottomNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Content1.screen_route,
        modifier = modifier
    ) {
        composable(BottomNavItem.Content1.screen_route) {
            Content1()
        }
        composable(BottomNavItem.Content4.screen_route) {
            Content4()
        }
    }
}