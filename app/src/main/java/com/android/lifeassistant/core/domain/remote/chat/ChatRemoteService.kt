package com.android.lifeassistant.core.domain.remote.chat

import com.android.lifeassistant.core.domain.model.user.MessageModel
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference

interface ChatRemoteService {

    fun getChatsOfUser(): CollectionReference

    fun getMessagesOfChat(chatUserUid: String): DocumentReference

    fun sendMessageToChat(chatUid: String, messageModel: MessageModel): Task<Void>
}