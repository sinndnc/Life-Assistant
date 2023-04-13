package com.android.lifeassistant.feature.presentation.main._task._view

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.lifeassistant.feature.presentation.main._task.TaskViewModel
import com.android.lifeassistant.feature.presentation.main._task._component.TaskFieldComponent
import com.android.lifeassistant.feature.presentation.main._task._component.TaskTimeComponent

@Composable
fun ColumnScope.TaskFieldView(taskViewModel: TaskViewModel) {
    Column(
        modifier = Modifier
            .weight(0.4f)
            .padding(15.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        TaskFieldComponent(taskViewModel = taskViewModel)
        TaskTimeComponent(taskViewModel = taskViewModel)
    }
}