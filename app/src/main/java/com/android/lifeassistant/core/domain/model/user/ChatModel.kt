package com.android.lifeassistant.core.domain.model.user


data class ChatModel(
    val chat_uid: String = "",
    val chat_name: String = "",
    val members: List<String> = listOf(),
    var messages: List<MessageModel> = listOf(),
)
