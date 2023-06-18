package com.android.lifeassistant.feature.presentation.main.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.lifeassistant.feature.navigation.content.NavigationBarContent
import com.android.lifeassistant.feature.presentation.main._calendar.CalendarContent
import com.android.lifeassistant.feature.presentation.main._calendar.CalendarViewModel
import com.android.lifeassistant.feature.presentation.main._home.HomeContent
import com.android.lifeassistant.feature.presentation.main._home.HomeViewModel
import com.android.lifeassistant.feature.presentation.main._message.MessageContent
import com.android.lifeassistant.feature.presentation.main._message.MessageViewModel
import com.android.lifeassistant.feature.presentation.main._profile.ProfileContent
import com.android.lifeassistant.feature.presentation.main._profile.ProfileViewModel

@Composable
fun NavigationHostComponent(
    innerPadding: PaddingValues,
    navController: NavController,
    navigationNavController: NavHostController,
) {

    NavHost(navigationNavController, startDestination = NavigationBarContent.Home.route, Modifier.padding(innerPadding)) {
        composable(NavigationBarContent.Home.route) {
            val homeViewModel = hiltViewModel<HomeViewModel>()
            HomeContent(homeViewModel = homeViewModel, navController = navController)
        }
        composable(NavigationBarContent.Message.route) {
            val messageViewModel = hiltViewModel<MessageViewModel>()
            MessageContent(viewModel = messageViewModel, navController = navController)
        }
        composable(NavigationBarContent.Calender.route) {
            val calendarViewModel = hiltViewModel<CalendarViewModel>()
            CalendarContent(viewModel = calendarViewModel)
        }
        composable(NavigationBarContent.Profile.route) {
            val profileViewModel = hiltViewModel<ProfileViewModel>()
            ProfileContent(viewModel = profileViewModel, navController = navController)
        }
    }
}