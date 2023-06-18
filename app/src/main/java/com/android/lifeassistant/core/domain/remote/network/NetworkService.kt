package com.android.lifeassistant.core.domain.remote.network

import com.android.lifeassistant.core.domain.model.notification.NotificationModel
import com.android.lifeassistant.core.util.event.ResponseState
import kotlinx.coroutines.flow.Flow

interface NetworkService {

    fun sendNotificationToSpecificUser(notificationModel: NotificationModel): Flow<ResponseState<Any>>
}