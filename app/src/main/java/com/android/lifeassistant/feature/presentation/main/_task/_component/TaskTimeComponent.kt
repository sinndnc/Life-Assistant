package com.android.lifeassistant.feature.presentation.main._task._component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.android.lifeassistant.feature.component.text.LifeAssistantText
import LifeAssistant.R
import androidx.compose.foundation.clickable
import androidx.compose.ui.unit.dp
import com.android.lifeassistant.feature.presentation.main._task.TaskViewModel

@Composable
fun ColumnScope.TaskTimeComponent(taskViewModel: TaskViewModel) {
    Row(
        modifier = Modifier.weight(0.3f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .weight(0.5f)
                .fillMaxSize()
                .clickable { taskViewModel.timeOnStartPressed() },
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.Start,
        ) {
            LifeAssistantText(text = "Start time", style = MaterialTheme.typography.body2)
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .fillMaxHeight(0.75f)
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.DarkGray.copy(0.4f)),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(modifier = Modifier.padding(10.dp)) {
                    Icon(
                        painterResource(id = R.drawable.schedule),
                        contentDescription = "start schedule",
                        tint = MaterialTheme.colors.onSurface
                    )
                    LifeAssistantText(text = "06:00 PM")
                }
            }
        }
        Column(
            modifier = Modifier
                .weight(0.5f)
                .fillMaxSize()
                .clickable { taskViewModel.timeOnFinishPressed() },
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.Start,
        ) {
            LifeAssistantText(text = "End time", style = MaterialTheme.typography.body2)
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .fillMaxHeight(0.75f)
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.DarkGray.copy(0.4f)),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(modifier = Modifier.padding(10.dp)) {
                    Icon(
                        painterResource(id = R.drawable.schedule),
                        contentDescription = "end schedule",
                        tint = MaterialTheme.colors.onSurface
                    )
                    LifeAssistantText(text = "09:00 PM")
                }
            }
        }
    }
}