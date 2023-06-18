package com.android.lifeassistant.core.data.repository.chat

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.android.lifeassistant.core.domain.model.notification.NotificationModel
import com.android.lifeassistant.core.domain.model.user.ChatModel
import com.android.lifeassistant.core.domain.model.user.MessageModel
import com.android.lifeassistant.core.domain.remote.chat.ChatRemoteService
import com.android.lifeassistant.core.domain.remote.network.NetworkService
import com.android.lifeassistant.core.domain.repostitory.chat.ChatRepository
import com.android.lifeassistant.core.util.annotation.IoDispatcher
import com.android.lifeassistant.core.util.event.ResponseState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val networkService: NetworkService,
    private val chatRemoteService: ChatRemoteService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : ChatRepository {

    private val _chatList: SnapshotStateList<ChatModel> = mutableStateListOf()
    override val chatList: SnapshotStateList<ChatModel> = _chatList

    override fun getChatsOfUser() {
        chatRemoteService.getChatsOfUser().addSnapshotListener { value, error ->
            if (error != null) {
                return@addSnapshotListener
            }
            if (value != null && value.documents.isNotEmpty()) {
                _chatList.removeAll(_chatList)
                for (doc in value.documents) {
                    doc.toObject(ChatModel::class.java)?.let { _chatList.add(it) }
                }
            }
        }
    }

    override fun getMessagesOfChat(chat_uid: String): Flow<ResponseState<MutableList<MessageModel>>> = callbackFlow {
        send(ResponseState.Loading)
        chatRemoteService.getMessagesOfChat(chat_uid).addSnapshotListener { value, error ->
            if (error != null) {
                return@addSnapshotListener
            }
            if (value != null && value.exists()) {
                val chatModel = value.toObject(ChatModel::class.java)!!
                val messageList = mutableListOf<MessageModel>()
                for (message in chatModel.messages.reversed()) {
                    messageList.add(message)
                }
                trySend(ResponseState.Success(messageList))
            }
        }
        awaitClose {}
    }

    override fun sendMessageToChat(chatUid: String, messageModel: MessageModel, notificationModel: NotificationModel) {
        chatRemoteService.sendMessageToChat(chatUid = chatUid, messageModel = messageModel)
        networkService.sendNotificationToSpecificUser(notificationModel).launchIn(CoroutineScope(ioDispatcher))
    }

}