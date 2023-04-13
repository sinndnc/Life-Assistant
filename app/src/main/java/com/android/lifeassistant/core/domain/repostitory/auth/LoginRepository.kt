package com.android.lifeassistant.core.domain.repostitory.auth

import com.android.lifeassistant.core.domain.model.auth.LoginModel
import com.android.lifeassistant.core.util.event.ResponseState
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    fun loginWithEmailAndPassword(model: LoginModel): Flow<ResponseState<String?>>
}