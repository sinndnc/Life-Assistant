package com.android.lifeassistant.feature.presentation.auth.login.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.android.lifeassistant.feature.component.textfield.LifeAssistantTextField
import com.android.lifeassistant.feature.presentation.auth.login.LoginViewModel

@Composable
fun LoginColumnForm(viewModel: LoginViewModel) {
    Column {
        LifeAssistantTextField(
            value = viewModel.email,
            label = "email",
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        )
        Spacer(modifier = Modifier.height(10.dp))
        LoginPasswordTextField(password = viewModel.password, isVisible = viewModel.isVisible)
    }
}