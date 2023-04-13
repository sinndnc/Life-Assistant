package com.android.lifeassistant.core.data.repository.auth

import com.android.lifeassistant.core.domain.model.auth.LoginModel
import com.android.lifeassistant.core.domain.remote.auth.LoginService
import com.android.lifeassistant.core.domain.repostitory.auth.LoginRepository
import com.android.lifeassistant.core.util.annotation.IoDispatcher
import com.android.lifeassistant.core.util.event.ResponseState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginService: LoginService,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : LoginRepository {

    override fun loginWithEmailAndPassword(model: LoginModel): Flow<ResponseState<String?>> =
        flow {
            emit(ResponseState.Loading)
            val response = loginService.loginWithEmailAndPassword(model).await()
            if (response.user != null) {
                emit(ResponseState.Success(response.user!!.uid))
            }
        }.catch { error ->
            emit(ResponseState.Error(error))
        }.flowOn(dispatcher)


}