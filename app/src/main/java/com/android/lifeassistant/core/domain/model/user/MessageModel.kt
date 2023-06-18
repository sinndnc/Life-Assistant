package com.android.lifeassistant.core.domain.model.user

import com.google.firebase.Timestamp

data class MessageModel(
    var message: String = "",
    var sender_uid: String = "",
    var message_date: Timestamp = Timestamp.now(),
    var isSelected: Boolean = false
)