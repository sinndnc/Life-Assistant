package com.android.lifeassistant.feature.presentation.main._calendar._component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import com.android.lifeassistant.core.constant.TaskConstant
import com.android.lifeassistant.core.domain.model.util.CalendarTaskModel

@Composable
fun TimeGraph(
    items: List<CalendarTaskModel>,
    date: @Composable () -> Unit,
    hour: @Composable () -> Unit,
    calendar: @Composable () -> Unit,
    task: @Composable (hour: Int, item: CalendarTaskModel) -> Unit,
    modifier: Modifier = Modifier,
) {

    val tasks = @Composable { items.forEachIndexed { index, calendarModel -> task(index, calendarModel) } }
    val calendars = @Composable { repeat((TaskConstant.days.size * TaskConstant.hours.size)) { calendar() } }

    Layout(
        modifier = modifier,
        contents = listOf(hour, date, tasks, calendars),
    ) { (hoursMeasurable, datesMeasurable, tasksMeasurable, calendarMeasurable), constraints ->

        val tasksPlaceable = tasksMeasurable.map { measurable ->
            val placeable = measurable.measure(constraints)
            placeable
        }
        val taskPlaceable = tasksPlaceable.first()

        val calendarsPlaceable = calendarMeasurable.map { measurable ->
            val placeable = measurable.measure(constraints)
            placeable
        }
        val calendarPlaceable = calendarsPlaceable.first()

        val hoursInt = 25
        val daysInt = 30
        val hourPlaceable = hoursMeasurable.first().measure(constraints)
        val datePlaceable = datesMeasurable.first().measure(constraints)

        val totalHeight = datePlaceable.height + (calendarPlaceable.height * hoursInt)
        val totalWidth = hourPlaceable.width + (calendarPlaceable.width * daysInt)

        layout(totalWidth, totalHeight) {
            var taskInt = 0
            val hourTextHeight = 15
            var xPosition = hourPlaceable.width
            var yPosition = datePlaceable.height

            hourPlaceable.place(0, yPosition - hourTextHeight)
            datePlaceable.place(xPosition, 0)

            calendarsPlaceable.forEachIndexed { calendarIndex, calendarPlaceable ->

                tasksPlaceable.forEachIndexed { taskIndex, taskPlaceable ->
                    val startTaskHourOfIndex = items[taskIndex].startingOfTaskHour
                    val taskDateOfIndex = items[taskIndex].dateOfTask
                    val taskDate = (taskDateOfIndex - 1) * taskPlaceable.width
                    if (startTaskHourOfIndex == calendarIndex) {
                        taskPlaceable.place(xPosition + taskDate, yPosition)
                    }
                }

                val dateOfTask = items[taskInt].dateOfTask
                val startingHourOfTask = ((dateOfTask - 1) * 24) + items[taskInt].startingOfTaskHour
                val finishingHourOfTask = ((dateOfTask - 1) * 24) + items[taskInt].finishingOfTaskHour

                if (calendarIndex !in startingHourOfTask until finishingHourOfTask) {
                    calendarPlaceable.place(xPosition, yPosition)
                    yPosition += calendarPlaceable.height

                    if (calendarIndex == finishingHourOfTask) {
                        if (items.lastIndex > taskInt) {
                            taskInt++
                        }
                    }
                } else {
                    yPosition += calendarPlaceable.height
                }

                if (yPosition == calendarPlaceable.height * 25) {
                    xPosition += calendarPlaceable.width
                    yPosition = datePlaceable.height
                }
            }
        }
    }
}

