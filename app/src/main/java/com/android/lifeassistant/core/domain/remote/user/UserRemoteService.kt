package com.android.lifeassistant.core.domain.remote.user

import com.android.lifeassistant.core.domain.model.user.UserModelApi
import com.android.lifeassistant.core.domain.model.user.UserModelUi
import com.android.lifeassistant.core.util.event.ResponseState
import kotlinx.coroutines.flow.Flow

interface UserRemoteService {
    fun insertUser(user: UserModelApi)
    fun getUserByUid(uid: String): UserModelApi
    fun getCurrentUser(): Flow<ResponseState<UserModelApi>>
    fun updateUserToken(newToken: String): Flow<ResponseState<String>>
    fun registerUserToken(): Flow<ResponseState<String>>
    fun sendMessageToUser()
}