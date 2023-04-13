package com.android.lifeassistant.core.domain.remote.auth

import com.android.lifeassistant.core.domain.model.auth.LoginModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface LoginService {

    fun loginWithEmailAndPassword(model : LoginModel): Task<AuthResult>
}