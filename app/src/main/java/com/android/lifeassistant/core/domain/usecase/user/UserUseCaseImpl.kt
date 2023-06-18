package com.android.lifeassistant.core.domain.usecase.user

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.android.lifeassistant.core.domain.mapper.toUserModelUi
import com.android.lifeassistant.core.domain.model.user.UserModelUi
import com.android.lifeassistant.core.domain.repostitory.storage.StorageRepository
import com.android.lifeassistant.core.domain.repostitory.user.UserRepository
import com.android.lifeassistant.core.util.annotation.IoDispatcher
import com.android.lifeassistant.feature.util.extension.toBitmap
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class UserUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository,
    private val storageRepository: StorageRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : UserUseCase {

    override val currentUserModel: MutableStateFlow<UserModelUi> = MutableStateFlow(UserModelUi())

    override fun invoke() {
        downloadCurrentUserImage()
        getCurrentUser()
    }

    private fun getCurrentUser() {
        userRepository.getCurrentUser().onEach { responseState ->
            responseState.onLoading {

            }.onSuccess { userModelApi ->
                Log.d("RemoteTest", userModelApi.toUserModelUi().toString() + "onsucces")
                currentUserModel.value = userModelApi.toUserModelUi()
            }.onError {

            }
        }.launchIn(CoroutineScope(ioDispatcher))
    }

    private fun downloadCurrentUserImage() {
        storageRepository.downloadProfileImageFromRemote().onEach { responseState ->
            responseState.onLoading {

            }.onSuccess { image ->
                currentUserModel.value.apply {
                    this.image = image
                }
            }.onError {

            }
        }.launchIn(CoroutineScope(ioDispatcher))
    }


}