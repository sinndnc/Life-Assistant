package com.android.lifeassistant.core.domain.model.util

import com.google.firebase.Timestamp

data class TaskModel(
    val task_name: String = "",
    val start_time: Timestamp = Timestamp.now(),
    val finish_time: Timestamp = Timestamp.now(),
    val task_description: String = "",
    val task_is_completed: Boolean = false,
    val task_priority: String = PriorityModel.MIDDLE.toString(),
)