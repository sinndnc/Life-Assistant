package com.android.lifeassistant.feature.navigation.main

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.android.lifeassistant.feature.navigation.content.Content
import com.android.lifeassistant.feature.presentation.main.MainContent
import com.android.lifeassistant.feature.presentation.main.MainViewModel
import com.android.lifeassistant.feature.presentation.main._task.TaskContent
import com.android.lifeassistant.feature.presentation.main._task.TaskViewModel

fun NavGraphBuilder.lifeAssistantMainGraph(navController: NavController) {
    navigation(
        route = Content.MAIN_GRAPH,
        startDestination = Content.Main.route
    ) {
        composable(Content.Main.route) {
            val mainViewModel = hiltViewModel<MainViewModel>()
            MainContent(navController = navController, viewModel = mainViewModel)
        }
        composable(Content.Task.route){
            val taskViewModel = hiltViewModel<TaskViewModel>()
            TaskContent(navController = navController,taskViewModel = taskViewModel)
        }
    }
}
