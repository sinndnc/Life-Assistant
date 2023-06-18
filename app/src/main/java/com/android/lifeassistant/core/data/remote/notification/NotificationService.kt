package com.android.lifeassistant.core.data.remote.notification

import android.R
import android.app.NotificationManager
import android.content.Context
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.Person
import androidx.core.graphics.drawable.IconCompat
import com.android.lifeassistant.core.constant.NotificationConstant
import com.android.lifeassistant.core.domain.model.notification.DataModel
import com.android.lifeassistant.core.domain.repostitory.user.UserRepository
import com.android.lifeassistant.core.util.notification.component.NotificationComponent
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@AndroidEntryPoint
class NotificationService : FirebaseMessagingService() {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var notificationComponent: NotificationComponent


    override fun onNewToken(token: String) {
        userRepository.updateUserToken(token).onEach { responseState ->
            responseState.onLoading {

            }.onSuccess {
                Log.d("NotificationTest", "received a new token : $token")
            }.onError {

            }
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }


    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        val data = remoteMessage.data
        if (data.isNotEmpty()) {
            val id = data[NotificationConstant.MODEL.id]
            val body = data[NotificationConstant.MODEL.body]
            val title = data[NotificationConstant.MODEL.title]
            val userId = data[NotificationConstant.MODEL.userId]
            if (body != null && title != null && id != null && userId != null) {
                val dataModel = DataModel(body = body, title = title, id = id.toInt(), userId = userId)
                buildNotification(dataModel)
            }
        }
    }


    private fun buildNotification(dataModel: DataModel) {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0, notificationComponent.buildGroupNotification(context = this, dataModel).build())
    }

}
