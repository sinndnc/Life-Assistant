package com.android.lifeassistant.core.data.repository.user

import android.net.ConnectivityManager
import com.android.lifeassistant.core.domain.model.user.UserModelApi
import com.android.lifeassistant.core.domain.model.util.TaskModel
import com.android.lifeassistant.core.domain.remote.user.UserRemoteService
import com.android.lifeassistant.core.domain.repostitory.user.UserRepository
import com.android.lifeassistant.core.util.event.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val connectivityManager: ConnectivityManager,
    private val userRemoteService: UserRemoteService,
) : UserRepository {
    override fun insertUser(userModel: UserModelApi) =
        userRemoteService.insertUser(userModel)
    override fun getUserByUid(uid: String): UserModelApi =
        userRemoteService.getUserByUid(uid)
    override fun getCurrentUser(): Flow<ResponseState<UserModelApi>> =
        userRemoteService.getCurrentUser()
    override fun updateUserToken(newToken: String): Flow<ResponseState<String>> =
        userRemoteService.updateUserToken(newToken)
    override fun registerUserToken(): Flow<ResponseState<String>> =
        userRemoteService.registerUserToken()
    override fun sendMessageToUser() = userRemoteService.sendMessageToUser()
    override fun getUserFriendList(friendList: List<String>): List<UserModelApi> =
        getUserFriendList(friendList)
    override suspend fun createTask(taskModel: TaskModel) {}
}