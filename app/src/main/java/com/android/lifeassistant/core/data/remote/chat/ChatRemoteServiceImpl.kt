package com.android.lifeassistant.core.data.remote.chat

import com.android.lifeassistant.core.constant.FirestoreConstants
import com.android.lifeassistant.core.domain.model.user.MessageModel
import com.android.lifeassistant.core.domain.remote.chat.ChatRemoteService
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class ChatRemoteServiceImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
) : ChatRemoteService {

    override fun getChatsOfUser(): CollectionReference =
        firestore.collection(FirestoreConstants.USER_COLLECTION)
            .document(firebaseAuth.uid!!)
            .collection(FirestoreConstants.USER_CHAT_COLLECTION)

    override fun getMessagesOfChat(chatUserUid: String): DocumentReference =
        firestore.collection(FirestoreConstants.USER_COLLECTION)
            .document(firebaseAuth.uid!!)
            .collection(FirestoreConstants.USER_CHAT_COLLECTION)
            .document(chatUserUid)

    override fun sendMessageToChat(chatUid: String, messageModel: MessageModel): Task<Void> =
        firestore.collection(FirestoreConstants.USER_COLLECTION)
            .document(firebaseAuth.uid!!)
            .collection(FirestoreConstants.USER_CHAT_COLLECTION)
            .document(chatUid)
            .update("messages", FieldValue.arrayUnion(messageModel))

}