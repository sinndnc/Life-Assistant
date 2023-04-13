package com.android.lifeassistant.feature.presentation.auth.onboard.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.lifeassistant.feature.presentation.auth.onboard.OnBoardViewModel
import com.android.lifeassistant.feature.util.extension.noRippleClickable

@Composable
fun ColumnScope.OnBoardSignUpForm(viewModel: OnBoardViewModel, navController: NavController) {

    val materialTheme = MaterialTheme.colors

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .weight(0.15f)
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "Don't have an account?", fontWeight = FontWeight.W400, color = materialTheme.onSurface)
        Spacer(modifier = Modifier.width(3.dp))
        Text(
            text = "Sign Up",
            fontWeight = FontWeight.W700,
            color = materialTheme.onSurface,
            modifier = Modifier.noRippleClickable {
                viewModel.navigateToSignUpContent(navController)
            })
    }
}