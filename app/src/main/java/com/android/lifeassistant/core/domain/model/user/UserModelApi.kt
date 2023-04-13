package com.android.lifeassistant.core.domain.model.user

import com.android.lifeassistant.core.domain.model.util.TaskModel

data class UserModelApi(
    val uid: String = "",
    var name: String = "",
    var email: String = "",
    var surname: String = "",
    var token: String = "",
    var tasks: List<TaskModel> = listOf(),
)
