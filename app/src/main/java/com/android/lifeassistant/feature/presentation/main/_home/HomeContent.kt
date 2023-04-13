package com.android.lifeassistant.feature.presentation.main._home

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import LifeAssistant.R
import com.android.lifeassistant.feature.presentation.main._home._view.*

@Composable
fun HomeContent(viewModel: HomeViewModel, navController: NavController) {

    Column {
        AppBarView(viewModel = viewModel)
        Column(
            modifier = Modifier
                .weight(0.65f)
                .fillMaxSize()
        ) {
            CategoryView()
            OngoingTestView(homeViewModel = viewModel)
        }
    }
}

