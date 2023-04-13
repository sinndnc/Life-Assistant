package com.android.lifeassistant.feature.presentation.main._task._component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.android.lifeassistant.feature.component.text.LifeAssistantText
import com.android.lifeassistant.feature.presentation.main._task.TaskViewModel
import kotlinx.coroutines.launch

@Composable
fun ColumnScope.CalendarComponent(taskViewModel: TaskViewModel) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp
    val coroutineScope = rememberCoroutineScope()
    val calendarListState = rememberLazyListState(taskViewModel.currentCalendar - 1)
    val calendarDayNameAndNumber = with(taskViewModel) {
        "$currentCalendar ${daysInMonth[currentCalendar].dayMonth} - ${currentCalendar + 6} ${daysInMonth[currentCalendar + 6].dayMonth}"
    }

    Column(
        modifier = Modifier
            .weight(0.2f)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .weight(0.350f)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { coroutineScope.launch { taskViewModel.calendarOnBackPressed(calendarListState) } }) {
                Icon(
                    Icons.Rounded.KeyboardArrowLeft,
                    contentDescription = "left calendar arrow",
                    tint = MaterialTheme.colors.onSurface
                )
            }
            LifeAssistantText(
                text = calendarDayNameAndNumber, style = MaterialTheme.typography.body1, fontWeight = FontWeight.Medium
            )
            IconButton(onClick = { coroutineScope.launch { taskViewModel.calendarOnForwardPress(calendarListState) } }) {
                Icon(
                    Icons.Rounded.KeyboardArrowRight, contentDescription = "right arrow", tint = MaterialTheme.colors.onSurface
                )
            }
        }
        LazyRow(
            modifier = Modifier
                .weight(0.650f)
                .fillMaxSize(),
            state = calendarListState,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            itemsIndexed(taskViewModel.daysInMonth) { index, item ->
                val isSelectedItem = taskViewModel.selectedDayList.find { it == item } != null
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Column(modifier = Modifier
                    .height(screenHeight.dp * 0.09f)
                    .width(screenWidth.dp * 0.115f)
                    .clip(MaterialTheme.shapes.medium)
                    .clickable { taskViewModel.selectCalendarDay(item) }
                    .background(if (isSelectedItem) MaterialTheme.colors.primary else MaterialTheme.colors.surface)
                    .border(width = 1.dp, color = Color.DarkGray, shape = MaterialTheme.shapes.medium),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {
                    Text(
                        text = item.dayName,
                        color = Color.White,
                        fontWeight = FontWeight.Normal,
                        style = MaterialTheme.typography.subtitle2
                    )
                    Text(text = item.dayNumber.toString(), color = Color.White)

                }
            }
        }

    }
}