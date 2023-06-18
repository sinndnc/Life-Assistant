package com.android.lifeassistant.core.util.notification.component

import LifeAssistant.R
import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.service.notification.StatusBarNotification
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.PRIORITY_HIGH
import com.android.lifeassistant.core.constant.NotificationConstant
import com.android.lifeassistant.core.domain.model.notification.DataModel
import com.android.lifeassistant.core.domain.model.notification.NotificationModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NotificationComponentImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : NotificationComponent {

    override val notificationManager: NotificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    private val activeNotifications: Array<out StatusBarNotification> = notificationManager.activeNotifications

    override fun checkIfNotificationIsActive(notificationId: Int): Boolean {
        var isActive = false
        for (activeNotification in activeNotifications) {
            isActive = activeNotification.id == notificationId
        }
        return isActive
    }

    override fun buildServiceNotification(activityContext: Context): Notification {
        val builder =
            NotificationCompat.Builder(activityContext, NotificationConstant.ID.GROUP_TASK_NOTIFICATION_CHANNEL).setSilent(true)
                .setOngoing(true).setShowWhen(false).setPriority(PRIORITY_HIGH).setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Service is Running").setCategory(Notification.CATEGORY_SERVICE)
        return builder.build()
    }

    override fun buildGroupNotification(context: Context, dataModel: DataModel): NotificationCompat.Builder {
        return NotificationCompat.Builder(context, NotificationConstant.ID.GROUP_TASK_NOTIFICATION_CHANNEL)
            .setPriority(PRIORITY_HIGH)
            .setSmallIcon(R.mipmap.ic_launcher)
    }

    override fun buildGroupSummaryNotification(context: Context, dataModel: DataModel): Notification {
        val builder = NotificationCompat.Builder(context, NotificationConstant.ID.GROUP_TASK_NOTIFICATION_CHANNEL)
            .setContentTitle(dataModel.title).setContentText("Two new messages").setSmallIcon(R.drawable.ic_launcher_background)
            .setStyle(
                NotificationCompat.InboxStyle().addLine("Alex Faarborg Check this out").addLine("Jeff Chang Launch Party")
                    .setBigContentTitle("2 new messages").setSummaryText("janedoe@example.com")
            ).setGroup(dataModel.userId).setGroupSummary(true)
        return builder.build()
    }

    override fun buildActionableNotification(notificationModel: NotificationModel) {
        TODO("Not yet implemented")
    }

}