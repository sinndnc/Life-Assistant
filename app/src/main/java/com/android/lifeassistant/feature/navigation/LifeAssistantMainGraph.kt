package com.android.lifeassistant.feature.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.android.lifeassistant.feature.presentation.main.home.HomeContent
import com.android.lifeassistant.feature.presentation.main.home.HomeViewModel

fun NavGraphBuilder.lifeAssistantMainGraph(navController: NavController) {
    navigation(
        route = Content.MAIN_GRAPH,
        startDestination = Content.Home.route
    ) {
        composable(Content.Home.route) {
            val homeViewModel = hiltViewModel<HomeViewModel>()
            HomeContent(viewModel = homeViewModel, navController = navController)
        }
    }
}
