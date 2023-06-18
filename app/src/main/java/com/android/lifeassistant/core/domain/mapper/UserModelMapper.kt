package com.android.lifeassistant.core.domain.mapper

import com.android.lifeassistant.core.domain.model.user.UserModelApi
import com.android.lifeassistant.core.domain.model.user.UserModelUi


fun UserModelApi.toUserModelUi(): UserModelUi = UserModelUi(
    uid = this.uid,
    name = this.name,
    email = this.email,
    surname = this.surname,
    token = this.token,
    tasks = this.tasks,
    chats = this.chats,
)


fun UserModelUi.toUserModelApi(): UserModelApi = UserModelApi(
    uid = this.uid,
    name = this.name,
    email = this.email,
    surname = this.surname,
    token = this.token,
    tasks = this.tasks,
    chats = this.chats,
)