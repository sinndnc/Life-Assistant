package com.android.lifeassistant.feature.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.lifeassistant.feature.presentation.splash.SplashContent
import com.android.lifeassistant.feature.presentation.splash.SplashViewModel

fun NavGraphBuilder.lifeAssistantSplashGraph(navController : NavController){
    composable(Content.Splash.route) {
        val splashViewModel = hiltViewModel<SplashViewModel>()
        SplashContent(viewModel = splashViewModel,navController = navController)
    }

}