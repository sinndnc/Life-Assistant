package com.android.lifeassistant.core.domain.model.user

data class UserModel(
    val uid: String = "",
    var name: String = "",
    var email: String = "",
    var surname: String = "",
    var token: String = "",
)