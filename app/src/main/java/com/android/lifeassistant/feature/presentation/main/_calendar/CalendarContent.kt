package com.android.lifeassistant.feature.presentation.main._calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.lifeassistant.core.constant.TaskConstant
import com.android.lifeassistant.feature.component.text.LifeAssistantText
import com.android.lifeassistant.feature.presentation.main._calendar._component.CalendarGridComponent
import com.android.lifeassistant.feature.presentation.main._calendar._component.DateComponent
import com.android.lifeassistant.feature.presentation.main._calendar._component.HourComponent
import com.android.lifeassistant.feature.presentation.main._calendar._component.TaskComponent
import com.android.lifeassistant.feature.presentation.main._calendar._component.TimeGraph
import com.chihsuanwu.freescroll.freeScroll
import com.chihsuanwu.freescroll.rememberFreeScrollState

@Composable
fun CalendarContent(viewModel: CalendarViewModel) {

    val taskList = viewModel.taskList
    val freeScrollState = rememberFreeScrollState()

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize(), horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                LifeAssistantText(
                    text = "February ",
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                )
                LifeAssistantText(
                    text = "2023",
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray.copy(0.75f)
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Rounded.KeyboardArrowLeft, "left Icon")
                    }
                    Spacer(modifier = Modifier.width(1.dp))
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Rounded.KeyboardArrowRight, "left Icon")
                    }
                }
                LifeAssistantText(
                    text = "Today",
                    color = Color.LightGray,
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier
                        .background(
                            Color.LightGray.copy(0.3f),
                            MaterialTheme.shapes.medium
                        )
                        .padding(4.dp),
                )
            }
        }

        TimeGraph(
            modifier = Modifier.freeScroll(freeScrollState),
            items = taskList,
            date = {
                Row {
                    TaskConstant.days.forEachIndexed { index, day ->
                        DateComponent("mon")
                    }
                }
            },
            hour = {
                Column {
                    TaskConstant.hours.forEachIndexed { index, hour ->
                        HourComponent("$hour AM")
                    }
                }
            },
            task = { index, task ->
                TaskComponent(task)
            },
            calendar = {
                CalendarGridComponent()
            },
        )
    }
}


@Composable
@Preview(showBackground = true)
fun CalendarContentPreview() {
    CalendarContent(hiltViewModel())
}

