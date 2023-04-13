package com.android.lifeassistant.feature.presentation.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.NavController
import com.android.lifeassistant.feature.presentation.auth.login.views.LoginAppBar
import com.android.lifeassistant.feature.presentation.auth.login.views.LoginForm
import com.android.lifeassistant.feature.util.extension.noRippleClickable
import com.android.lifeassistant.feature.util.extension.setThemeBackground

@Composable
fun LoginContent(viewModel: LoginViewModel, navController: NavController) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .noRippleClickable { focusManager.clearFocus() },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LoginAppBar(viewModel, navController)
        LoginForm(viewModel, navController)
        //Todo(adding ui)
        Box(
            modifier = Modifier
                .weight(0.45f)
                .fillMaxWidth()
        )
    }
}