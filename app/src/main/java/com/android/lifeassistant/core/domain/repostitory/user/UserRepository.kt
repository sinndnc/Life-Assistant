package com.android.lifeassistant.core.domain.repostitory.user

import com.android.lifeassistant.core.domain.model.user.UserModelApi
import com.android.lifeassistant.core.domain.model.util.TaskModel
import com.android.lifeassistant.core.util.event.ResponseState
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun insertUser(userModel: UserModelApi)
    fun getUserByUid(uid: String): UserModelApi
    fun getCurrentUser(): Flow<ResponseState<UserModelApi>>
    fun getUserFriendList(friendList: List<String>): List<UserModelApi>
    fun updateUserToken(newToken : String) : Flow<ResponseState<String>>
    suspend fun createTask(taskModel: TaskModel)
    fun registerUserToken(): Flow<ResponseState<String>>
    fun sendMessageToUser()
}