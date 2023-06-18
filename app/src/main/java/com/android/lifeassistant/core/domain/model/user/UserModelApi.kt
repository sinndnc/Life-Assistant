package com.android.lifeassistant.core.domain.model.user

import android.graphics.Bitmap
import com.android.lifeassistant.core.domain.model.util.TaskModel

data class UserModelApi(
    val uid: String = "",
    var name: String = "",
    var email: String = "",
    var token: String = "",
    var surname: String = "",
    var tasks: List<TaskModel> = listOf(),
    var chats: List<ChatModel> = listOf()
)
