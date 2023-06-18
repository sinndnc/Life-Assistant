package com.android.lifeassistant.feature.presentation.main

import androidx.lifecycle.ViewModel
import com.android.lifeassistant.core.domain.repostitory.chat.ChatRepository
import com.android.lifeassistant.core.domain.usecase.user.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userUseCase : UserUseCase
) : ViewModel() {

    init {
        userUseCase.invoke()
    }

}