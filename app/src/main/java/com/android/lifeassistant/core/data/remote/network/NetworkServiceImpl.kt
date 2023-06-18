package com.android.lifeassistant.core.data.remote.network

import com.android.lifeassistant.core.constant.NotificationConstant
import com.android.lifeassistant.core.domain.model.notification.NotificationModel
import com.android.lifeassistant.core.domain.remote.network.NetworkService
import com.android.lifeassistant.core.util.event.ResponseState
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NetworkServiceImpl @Inject constructor(
    private val httpClient: HttpClient,
) : NetworkService {

    override fun sendNotificationToSpecificUser(notificationModel: NotificationModel): Flow<ResponseState<Any>> =
        flow {
            emit(ResponseState.Loading)
            val response = httpClient.post(NotificationConstant.SERVER_URL) {
                contentType(ContentType.Application.Json)
                headers.append(HttpHeaders.Authorization, "key=${NotificationConstant.SERVER_KEY}")
                setBody(notificationModel)
            }
            emit(ResponseState.Success(response.body()))
        }

}