package com.android.lifeassistant.feature.presentation.main._task

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.lifeassistant.core.domain.model.util.TaskModel
import com.android.lifeassistant.feature.component.text.LifeAssistantText
import com.android.lifeassistant.feature.component.theme.Black600
import com.android.lifeassistant.feature.component.theme.Black700
import com.android.lifeassistant.feature.component.theme.Black800
import com.android.lifeassistant.feature.presentation.main._task._component.AppbarComponent
import com.android.lifeassistant.feature.presentation.main._task._component.CalendarComponent
import com.android.lifeassistant.feature.presentation.main._task._view.TaskFieldView
import com.android.lifeassistant.feature.util.extension.noRippleClickable
import com.google.firebase.Timestamp

@Composable
fun TaskContent(navController: NavController, taskViewModel: TaskViewModel) {

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .noRippleClickable { focusManager.clearFocus() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        AppbarComponent(navController = navController)
        CalendarComponent(taskViewModel = taskViewModel)
        TaskFieldView(taskViewModel = taskViewModel)
        Column(
            modifier = Modifier
                .weight(0.2f)
                .padding(15.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            LifeAssistantText(
                text = "Priority",
                modifier = Modifier
                    .weight(0.2f)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Medium
            )
            Row(
                modifier = Modifier
                    .weight(0.6f)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .weight(0.250f)
                        .fillMaxHeight(0.5f)
                        .clip(MaterialTheme.shapes.medium)
                        .background(Color.DarkGray.copy(0.4f)),
                    contentAlignment = Alignment.Center,
                ) {
                    LifeAssistantText(text = "High")
                }
                Spacer(modifier = Modifier.weight(0.125f))
                Box(
                    modifier = Modifier
                        .weight(0.250f)
                        .fillMaxHeight(0.5f)
                        .clip(MaterialTheme.shapes.medium)
                        .background(Color.DarkGray.copy(0.4f)),
                    contentAlignment = Alignment.Center,
                ) {
                    LifeAssistantText(text = "Middle")
                }
                Spacer(modifier = Modifier.weight(0.125f))
                Box(
                    modifier = Modifier
                        .weight(0.250f)
                        .fillMaxHeight(0.5f)
                        .clip(MaterialTheme.shapes.medium)
                        .background(Color.DarkGray.copy(0.4f)),
                    contentAlignment = Alignment.Center,
                ) {
                    LifeAssistantText(text = "Low")
                }
            }
            Row(
                modifier = Modifier
                    .weight(0.2f)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                LifeAssistantText(
                    text = "Get alert for this task",
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Medium
                )
                Switch(checked = true, onCheckedChange = {})
            }
        }
        Row(
            modifier = Modifier
                .weight(0.1f)
                .padding(15.dp)
                .fillMaxSize()
        ) {
            Button(onClick = { taskViewModel.createTask() }, modifier = Modifier.fillMaxSize()) {
                Text(text = "Create task")
            }
        }
    }
}