package com.android.lifeassistant.core.data.remote.storage

import com.android.lifeassistant.core.constant.FirestoreConstants
import com.android.lifeassistant.core.domain.model.user.UserModelApi
import com.android.lifeassistant.core.domain.model.util.TaskModel
import com.android.lifeassistant.core.domain.remote.storage.RemoteStorageService
import com.android.lifeassistant.core.util.annotation.IoDispatcher
import com.android.lifeassistant.core.util.event.ResponseState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class RemoteStorageServiceImpl @Inject constructor(
    private val storage: StorageReference,
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : RemoteStorageService {

    override fun getCurrentUser(): Flow<ResponseState<UserModelApi>> = flow {
        emit(ResponseState.Loading)
        val response = firestore.collection(FirestoreConstants.USER_COLLECTION).document(firebaseAuth.uid!!).get().await()
        val user = response.toObject(UserModelApi::class.java)!!.apply {
            //    image = getUserImage(uid)
        }
        if (response.exists()) emit(ResponseState.Success(user))
    }.catch { exception ->
        emit(ResponseState.Error(exception))
    }.flowOn(ioDispatcher)

    override fun getUserByUid(uid: String): UserModelApi = runBlocking(ioDispatcher) {
        val response = firestore.collection(FirestoreConstants.USER_COLLECTION).document(uid).get().await()
        response.toObject(UserModelApi::class.java)!!.apply {
            //image = getUserImage(uid)
        }
    }

    override fun insertUser(user: UserModelApi) {
        TODO("Not yet implemented")
    }

    override fun getUserImage(uid: String): ByteArray = runBlocking(ioDispatcher) {
        val response = storage.child("${FirestoreConstants.USER_COLLECTION}/$uid.jpg").getBytes(1024 * 1024).await()
        if (response.isNotEmpty()) response else byteArrayOf()
    }

    override suspend fun createTask(taskModel: TaskModel) {
        val taskData = hashMapOf("tasks" to FieldValue.arrayUnion(taskModel))
        firestore.collection(FirestoreConstants.USER_COLLECTION).document(firebaseAuth.uid!!).set(taskData, SetOptions.merge())

    }
}