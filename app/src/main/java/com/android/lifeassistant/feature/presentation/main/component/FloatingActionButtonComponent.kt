package com.android.lifeassistant.feature.presentation.main.component

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.android.lifeassistant.feature.navigation.content.Content

@Composable
fun FloatingActionButtonComponent(navController: NavController) {

    FloatingActionButton(
        shape = CircleShape,
        onClick = { navController.navigate(Content.Task.route) },
        backgroundColor = MaterialTheme.colors.secondary,
        contentColor = Color.White
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add icon")
    }
}