package com.android.lifeassistant.core.data.repository

import android.net.ConnectivityManager
import com.android.lifeassistant.core.domain.model.user.UserModelApi
import com.android.lifeassistant.core.domain.model.util.TaskModel
import com.android.lifeassistant.core.domain.remote.storage.RemoteStorageService
import com.android.lifeassistant.core.domain.repostitory.StorageRepository
import com.android.lifeassistant.core.util.event.ResponseState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StorageRepositoryImpl @Inject constructor(
    private val connectivityManager: ConnectivityManager,
    private val remoteStorageService: RemoteStorageService,
) : StorageRepository {

    override fun insertUser(userModel: UserModelApi) =
        remoteStorageService.insertUser(userModel)

    override fun getUserByUid(uid: String): UserModelApi =
        remoteStorageService.getUserByUid(uid)

    override fun getCurrentUser(): Flow<ResponseState<UserModelApi>> =
        remoteStorageService.getCurrentUser()

    override fun getUserFriendList(friendList: List<String>): List<UserModelApi> =
        getUserFriendList(friendList)

    override suspend fun createTask(taskModel: TaskModel) =
        remoteStorageService.createTask(taskModel)
}