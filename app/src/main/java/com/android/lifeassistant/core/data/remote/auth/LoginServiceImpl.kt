package com.android.lifeassistant.core.data.remote.auth

import com.android.lifeassistant.core.domain.model.auth.LoginModel
import com.android.lifeassistant.core.domain.remote.auth.LoginService
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class LoginServiceImpl @Inject constructor(
    private val auth: FirebaseAuth
) : LoginService {

    override fun loginWithEmailAndPassword(model: LoginModel): Task<AuthResult> =
        auth.signInWithEmailAndPassword(model.email, model.password)

}