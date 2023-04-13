package com.android.lifeassistant.feature.presentation.main.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.android.lifeassistant.feature.component.theme.Black900
import com.android.lifeassistant.feature.navigation.content.NavigationBarContent
import com.android.lifeassistant.feature.navigation.content.NavigationBarContent.Companion.navigationItemList

@Composable
fun BottomNavigationComponent(navigationNavController: NavController) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    BottomAppBar(
        cutoutShape = CircleShape,
        backgroundColor = Black900,
    ) {
        BottomNavigation(
            backgroundColor = Black900,
        ) {
            val navBackStackEntry by navigationNavController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            navigationItemList.forEach { screen ->
                if (screen == NavigationBarContent.Calender) {
                    Spacer(modifier = Modifier.width(screenWidth.dp * 0.125f))
                }
                val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = if (isSelected) screen.selectedIcon else screen.unSelectedIcon),
                            contentDescription = null
                        )
                    },
                    alwaysShowLabel = false,
                    label = { Text(screen.route) },
                    selected = isSelected,
                    onClick = {
                        navigationNavController.navigate(screen.route) {
                            popUpTo(navigationNavController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}