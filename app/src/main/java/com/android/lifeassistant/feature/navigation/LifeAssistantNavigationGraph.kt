package com.android.lifeassistant.feature.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun LifeAssistantNavigationGraph() {
    val navController = rememberNavController()

    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = Content.Splash.route,
    ) {
        lifeAssistantSplashGraph(navController = navController)
        lifeAssistantAuthGraph(navController = navController)
        lifeAssistantMainGraph(navController = navController)
    }
}