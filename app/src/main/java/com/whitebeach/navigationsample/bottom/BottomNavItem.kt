package com.whitebeach.navigationsample.bottom

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Face
import androidx.compose.ui.graphics.vector.ImageVector
import com.whitebeach.navigationsample.R

sealed class BottomNavItem(
    var title: String,
    var icon: ImageVector,
    var screen_route: String
) {


    object Content1 : BottomNavItem(
        title ="content1",
        icon = Icons.Outlined.AddCircle,
        screen_route = "content1"
    )

    object Content4 : BottomNavItem(
        title ="content4",
        icon = Icons.Outlined.Face,
        screen_route = "content4"
    )

}

