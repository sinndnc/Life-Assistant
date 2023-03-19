package com.android.lifeassistant.core.domain.usecase.splash

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class SplashUseCaseImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
) : SplashUseCase {

    override fun execute(): Boolean = firebaseAuth.currentUser != null

}