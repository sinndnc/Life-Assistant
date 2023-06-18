package com.android.lifeassistant.feature.presentation.main._profile

import androidx.lifecycle.ViewModel
import com.android.lifeassistant.core.domain.repostitory.storage.StorageRepository
import com.android.lifeassistant.core.domain.usecase.user.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userUseCase: UserUseCase,
     val storageRepository: StorageRepository,
) : ViewModel() {

    val userModel = userUseCase.currentUserModel

}