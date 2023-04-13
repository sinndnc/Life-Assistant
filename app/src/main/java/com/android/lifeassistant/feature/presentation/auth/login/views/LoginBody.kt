package com.android.lifeassistant.feature.presentation.auth.login.views

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.android.lifeassistant.core.domain.model.auth.LoginModel
import com.android.lifeassistant.feature.presentation.auth.login.LoginViewModel
import com.android.lifeassistant.feature.presentation.auth.login.component.LoginButton
import com.android.lifeassistant.feature.presentation.auth.login.component.LoginColumnForm
import com.android.lifeassistant.feature.presentation.auth.login.component.LoginTextForm

@Composable
fun ColumnScope.LoginForm(viewModel: LoginViewModel, navController: NavController) {

    Column(
        modifier = Modifier
            .weight(0.45f)
            .fillMaxWidth(0.85f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        LoginTextForm()
        LoginColumnForm(viewModel = viewModel)
        LoginButton(state = viewModel.uiState.value) {
            viewModel.loginWithEmailAndPassword(
                LoginModel(viewModel.email.value, viewModel.password.value),
                navController
            )
        }
    }
}