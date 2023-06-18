package com.android.lifeassistant.core.domain.usecase.user

import androidx.compose.runtime.MutableState
import com.android.lifeassistant.core.domain.model.user.UserModelUi
import kotlinx.coroutines.flow.MutableStateFlow

interface UserUseCase {

    operator fun invoke()

    val currentUserModel: MutableStateFlow<UserModelUi>
}