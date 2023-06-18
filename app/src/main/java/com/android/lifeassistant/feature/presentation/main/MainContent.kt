package com.android.lifeassistant.feature.presentation.main

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.android.lifeassistant.feature.presentation.main.component.BottomNavigationComponent
import com.android.lifeassistant.feature.presentation.main.component.FloatingActionButtonComponent
import com.android.lifeassistant.feature.presentation.main.component.NavigationHostComponent

@Composable
fun MainContent(navController: NavController, mainViewModel : MainViewModel) {

    val navigationNavController = rememberNavController()

    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        bottomBar = { BottomNavigationComponent(navigationNavController) },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = { FloatingActionButtonComponent(navController = navController) }
    ) { innerPadding ->
        NavigationHostComponent(
            innerPadding = innerPadding,
            navController = navController,
            navigationNavController = navigationNavController,
        )
    }
}