package com.android.lifeassistant.feature.presentation.auth.onboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.lifeassistant.feature.presentation.auth.onboard.views.OnBoardLoginForm
import com.android.lifeassistant.feature.presentation.auth.onboard.views.OnBoardSignUpForm
import com.android.lifeassistant.feature.util.extension.setThemeBackground

@Composable
fun OnBoardContent(viewModel: OnBoardViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.weight(0.75f))
        OnBoardLoginForm(viewModel, navController)
        OnBoardSignUpForm(viewModel, navController)
    }
}
