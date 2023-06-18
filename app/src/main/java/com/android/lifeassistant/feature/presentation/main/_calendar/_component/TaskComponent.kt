package com.android.lifeassistant.feature.presentation.main._calendar._component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.lifeassistant.core.domain.model.util.CalendarTaskModel
import com.android.lifeassistant.feature.component.text.LifeAssistantText
import com.android.lifeassistant.feature.component.theme.Yellow200

@Composable
fun TaskComponent(taskModel: CalendarTaskModel) {

    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp.dp * 0.3f
    val height = configuration.screenHeightDp.dp * 0.05f
    val taskStartingHour = taskModel.startingOfTaskHour
    val taskFinishingHour = taskModel.finishingOfTaskHour
    val diffHour = taskFinishingHour - taskStartingHour
    val flexibleHeight = height * diffHour

    Box(
        modifier = Modifier
            .width(width)
            .height(flexibleHeight)
            .border((1 * 0.56).dp, Color.Gray.copy(0.9f)),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .padding(10.dp)
                .clip(MaterialTheme.shapes.medium)
                .fillMaxSize()
                .background(Yellow200),
            contentAlignment = Alignment.TopStart,
        ) {
            Column(
                modifier = Modifier
                    .padding(3.dp)
            ) {
                LifeAssistantText(
                    text = taskModel.taskContent,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.caption,
                )
                LifeAssistantText(
                    text = "${taskModel.startingOfTaskHour} AM",
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.overline,
                )
            }
        }
    }
}

@Preview
@Composable
fun TaskComponentPreview() {
    TaskComponent(CalendarTaskModel(1, 2, 4,"morning run"))
}