package com.android.lifeassistant.feature.presentation.main._task._component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.android.lifeassistant.feature.component.text.LifeAssistantText
import com.android.lifeassistant.feature.component.textfield.LifeAssistantTextField
import com.android.lifeassistant.feature.presentation.main._task.TaskViewModel

@Composable
fun ColumnScope.TaskFieldComponent(taskViewModel: TaskViewModel) {

    Column(
        modifier = Modifier.weight(0.6f),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.Start
    ) {
        LifeAssistantText(
            text = "Schedule",
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Medium
        )
        LifeAssistantTextField(
            value = taskViewModel.taskNameState,
            label = "Task name"
        )
        LifeAssistantTextField(
            value = taskViewModel.taskDescriptionState,
            label = "Task Description"
        )
    }
    Spacer(modifier = Modifier.weight(0.1f))
}