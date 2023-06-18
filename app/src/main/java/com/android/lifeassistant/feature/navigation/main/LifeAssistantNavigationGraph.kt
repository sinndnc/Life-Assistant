package com.android.lifeassistant.feature.navigation.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.android.lifeassistant.feature.navigation.content.Content
import com.android.lifeassistant.feature.util.extension.setThemeBackground

@Composable
fun LifeAssistantNavigationGraph() {
    val navController = rememberNavController()

    NavHost(
        modifier = Modifier
            .fillMaxSize()
            .setThemeBackground(),
        navController = navController,
        startDestination = Content.Splash.route,
    ) {
        lifeAssistantSplashGraph(navController = navController)
        lifeAssistantAuthGraph(navController = navController)
        lifeAssistantMainGraph(navController = navController)
    }
}