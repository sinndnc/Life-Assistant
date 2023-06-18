package com.android.lifeassistant.core.domain.repostitory.chat

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.android.lifeassistant.core.domain.model.notification.NotificationModel
import com.android.lifeassistant.core.domain.model.user.ChatModel
import com.android.lifeassistant.core.domain.model.user.MessageModel
import com.android.lifeassistant.core.util.event.ResponseState
import kotlinx.coroutines.flow.Flow

interface ChatRepository {

    val chatList: SnapshotStateList<ChatModel>

    fun getChatsOfUser()

    fun getMessagesOfChat(chat_uid: String): Flow<ResponseState<MutableList<MessageModel>>>

    fun sendMessageToChat(chatUid: String, messageModel: MessageModel, notificationModel: NotificationModel)
}