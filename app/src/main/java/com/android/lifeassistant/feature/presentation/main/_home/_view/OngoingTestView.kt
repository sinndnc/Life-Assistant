package com.android.lifeassistant.feature.presentation.main._home._view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.android.lifeassistant.feature.presentation.main._home.HomeViewModel
import com.android.lifeassistant.feature.presentation.main._home._component.ListComponent
import com.android.lifeassistant.feature.presentation.main._home._component.OngoingTaskComponent

@Composable
fun ColumnScope.OngoingTestView(homeViewModel: HomeViewModel) {
    Column(
        modifier = Modifier
            .weight(0.6f)
            .fillMaxSize()
    ) {
        ListComponent(categoryName = "Ongoing Task", categoryCaption = "See all", onClick = {}) {
            OngoingTaskComponent(homeViewModel = homeViewModel)
        }
    }
}