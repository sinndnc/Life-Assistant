package com.android.lifeassistant.core.util.notification.component

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.android.lifeassistant.core.domain.model.notification.DataModel
import com.android.lifeassistant.core.domain.model.notification.NotificationModel

interface NotificationComponent {
    val notificationManager: NotificationManager
    fun buildServiceNotification(activityContext: Context): Notification
    fun buildGroupNotification(context: Context,dataModel: DataModel): NotificationCompat.Builder
    fun buildActionableNotification(notificationModel: NotificationModel)
    fun buildGroupSummaryNotification(context: Context, dataModel: DataModel): Notification
    fun checkIfNotificationIsActive(notificationId: Int): Boolean
}