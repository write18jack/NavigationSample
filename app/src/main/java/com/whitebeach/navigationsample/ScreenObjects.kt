package com.whitebeach.navigationsample

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

//TopBar用interface
sealed interface Screen {
    val route: String
    val topBarTitle: @Composable () -> Unit
    val navigationIcon: @Composable (() -> Unit)?
    val actionsIcon: @Composable (RowScope.() -> Unit)?

    fun NavGraphBuilder.content(navController: NavController)
}


// Screenを継承
object Content1 : Screen {

    var onClickActionsIcon: () -> Unit = {}

    override val route: String = "content1"

    override val topBarTitle: @Composable () -> Unit
        get() = {
            Text(text = "Content1")
        }

    override val navigationIcon: @Composable (() -> Unit)
        get() = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
            }
        }

    override val actionsIcon: @Composable() (RowScope.() -> Unit)
        get() = {
            IconButton(onClick = onClickActionsIcon) {
                Icon(imageVector = Icons.Default.Check, contentDescription = null)
            }
        }

    override fun NavGraphBuilder.content(navController: NavController) {
        composable(route = this@Content1.route) {
            Content1(
                navController
            )
        }
    }
}

// Screenを継承
object Content2 : Screen {

    var onClickTopBarIcon: () -> Unit = {}
    var onClickActionsIcon: () -> Unit = {}

    override val route: String = "content2"

    override val topBarTitle: @Composable () -> Unit
        get() = {
            Text(text = "Content2")
        }

    override val navigationIcon: @Composable (() -> Unit)
        get() = {
            IconButton(onClick = onClickTopBarIcon) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        }

    override val actionsIcon: @Composable() (RowScope.() -> Unit)
        get() = {
            IconButton(onClick = onClickActionsIcon) {
                Icon(imageVector = Icons.Default.Build, contentDescription = null)
            }
        }

    override fun NavGraphBuilder.content(navController: NavController) {
        composable(route = this@Content2.route) {
            Content2(navController = navController)
        }
    }
}

// Screenを継承
object Content3 : Screen {

    var onClickTopBarIcon: () -> Unit = {}

    override val route: String = "content3"

    override val topBarTitle: @Composable () -> Unit
        get() = {
            Text(text = "Content3 ")
        }

    override val navigationIcon: @Composable (() -> Unit)
        get() = {
            IconButton(onClick = onClickTopBarIcon) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        }

    override val actionsIcon: @Composable() (RowScope.() -> Unit)
        get() = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
            }
        }

    override fun NavGraphBuilder.content(navController: NavController) {
        composable(route = this@Content3.route) {
            Content3(
                navController = navController,
            )
        }
    }
}