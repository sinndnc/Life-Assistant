package com.android.lifeassistant.core.domain.remote.storage

import com.android.lifeassistant.core.domain.model.user.UserModelApi
import com.android.lifeassistant.core.domain.model.util.TaskModel
import com.android.lifeassistant.core.util.event.ResponseState
import kotlinx.coroutines.flow.Flow

interface RemoteStorageService {

    fun getUserByUid(uid: String): UserModelApi

    fun getCurrentUser(): Flow<ResponseState<UserModelApi>>

    fun insertUser(user: UserModelApi)

    fun getUserImage(uid: String): ByteArray

    suspend fun createTask(taskModel: TaskModel)
}
