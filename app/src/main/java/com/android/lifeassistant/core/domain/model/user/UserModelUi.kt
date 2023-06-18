package com.android.lifeassistant.core.domain.model.user

import android.graphics.Bitmap
import androidx.compose.runtime.MutableState
import com.android.lifeassistant.core.domain.model.util.TaskModel

data class UserModelUi(
    val uid: String = "",
    var name: String = "",
    var email: String = "",
    var surname: String = "",
    var token: String = "",
    var tasks: List<TaskModel> = listOf(),
    var chats: List<ChatModel> = listOf(),
    var image: Bitmap? = null,
)
