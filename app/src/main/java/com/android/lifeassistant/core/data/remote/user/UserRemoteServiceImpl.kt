package com.android.lifeassistant.core.data.remote.user

import android.util.Log
import com.android.lifeassistant.core.constant.FirestoreConstants
import com.android.lifeassistant.core.domain.model.user.UserModelApi
import com.android.lifeassistant.core.domain.remote.user.UserRemoteService
import com.android.lifeassistant.core.util.annotation.IoDispatcher
import com.android.lifeassistant.core.util.event.ResponseState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.RemoteMessage
import com.google.firebase.messaging.ktx.messaging
import com.google.firebase.messaging.ktx.remoteMessage
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserRemoteServiceImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
    private val firebaseMessaging: FirebaseMessaging,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : UserRemoteService {

    override fun getCurrentUser(): Flow<ResponseState<UserModelApi>> = callbackFlow {
        send(ResponseState.Loading)
        firestore.collection(FirestoreConstants.USER_COLLECTION).document(firebaseAuth.uid!!).get()
            .addOnSuccessListener { value ->
                val user = value.toObject(UserModelApi::class.java)!!
                trySend(ResponseState.Success(user))
            }.addOnFailureListener {
                Log.d("RemoteTest", it.toString())
            }
        awaitClose {}
    }.flowOn(ioDispatcher)

    override fun getUserByUid(uid: String): UserModelApi = runBlocking(ioDispatcher) {
        val response = firestore.collection(FirestoreConstants.USER_COLLECTION).document(uid).get().await()
        response.toObject(UserModelApi::class.java)!!
    }

    override fun updateUserToken(newToken: String): Flow<ResponseState<String>> = callbackFlow {
        send(ResponseState.Loading)
        firestore.collection(FirestoreConstants.USER_COLLECTION).document(firebaseAuth.uid!!)
            .update(FirestoreConstants.USER_TOKEN, newToken)
            .addOnSuccessListener {
                trySend(ResponseState.Success(newToken))
            }.addOnFailureListener {
                trySend(ResponseState.Error(it))
            }
    }

    override fun registerUserToken(): Flow<ResponseState<String>> = callbackFlow {
        send(ResponseState.Loading)
        firebaseMessaging.token.addOnSuccessListener { token ->
            updateUserToken(token).launchIn(CoroutineScope(ioDispatcher))
            trySend(ResponseState.Success(token))
        }.addOnFailureListener {
            trySend(ResponseState.Error(it))
        }
    }

    override fun sendMessageToUser() {

    }

    override fun insertUser(user: UserModelApi) {
        TODO("Not yet implemented")
    }

}