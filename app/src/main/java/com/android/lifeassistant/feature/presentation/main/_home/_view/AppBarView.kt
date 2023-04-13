package com.android.lifeassistant.feature.presentation.main._home._view

import LifeAssistant.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.android.lifeassistant.feature.presentation.main._home.HomeViewModel

@Composable
fun ColumnScope.AppBarView(viewModel : HomeViewModel) {
    Column(
        modifier = Modifier
            .weight(0.35f)
            .fillMaxSize()
    ) {
        ProfileView(
            onGoingTasks = 3,
            profileName = "Morning,Micheal",
            profileImage = R.drawable.ic_launcher_background
        )
        ActivityView(viewModel = viewModel)
    }
}