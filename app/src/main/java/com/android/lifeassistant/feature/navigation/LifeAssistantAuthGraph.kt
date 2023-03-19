package com.android.lifeassistant.feature.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.android.lifeassistant.feature.presentation.auth.onboard.OnBoardContent
import com.android.lifeassistant.feature.presentation.auth.onboard.OnBoardViewModel

fun NavGraphBuilder.lifeAssistantAuthGraph(navController : NavController) {
    navigation(
        startDestination = Content.OnBoard.route,
        route = Content.AUTH_GRAPH
    ) {
        composable(Content.OnBoard.route) {
            val onBoardViewModel = hiltViewModel<OnBoardViewModel>()
            OnBoardContent(viewModel = onBoardViewModel, navController = navController)
        }

    }
}