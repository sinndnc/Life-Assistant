package com.android.lifeassistant.core.domain.model.util

data class CalendarTaskModel(
    val dateOfTask: Int,
    val startingOfTaskHour: Int,
    val finishingOfTaskHour: Int,
    val taskContent: String,
)