package com.android.lifeassistant.core.util.notification

import android.app.NotificationManager

interface NotificationHelper {

    val notificationManager: NotificationManager

    fun createNotificationChannelIfNotExists(channelId: String, channelName: String, channelDescription: String, groupId: String)

    fun createNotificationChannelGroupIfNotExists(groupId: String, groupName: String, groupDescription: String)

    fun createTaskNotificationChannel()

}