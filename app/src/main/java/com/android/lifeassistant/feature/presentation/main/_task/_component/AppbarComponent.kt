package com.android.lifeassistant.feature.presentation.main._task._component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.android.lifeassistant.feature.component.text.LifeAssistantText

@Composable
fun ColumnScope.AppbarComponent(navController : NavController) {
    Row(
        modifier = Modifier
            .weight(0.1f)
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(Icons.Rounded.Close, contentDescription = "Close task", tint = MaterialTheme.colors.onSurface)
        }
        LifeAssistantText(text = "Create new task", style = MaterialTheme.typography.h6, fontWeight = FontWeight.Bold)
        IconButton(onClick = { }) {
            Icon(Icons.Rounded.Info, contentDescription = "Close task", tint = MaterialTheme.colors.onSurface)
        }
    }
}