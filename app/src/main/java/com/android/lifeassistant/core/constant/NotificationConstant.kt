package com.android.lifeassistant.core.constant

object NotificationConstant {

    const val SERVER_KEY =
        "AAAAs2gfJS0:APA91bFqoRJ3pzbZhCQshGAOmPxanqnOTlfZie3UCeEmUK6DmhVE9kltnxu9caHfYQctXERwfO3hC8TkhN2n0HIzJe_Vp-fZBl9FBdnzEp8KUQEW5j7gWrtV0f06LQcgSbMLuOtpAain"
    const val SERVER_URL = "https://fcm.googleapis.com/fcm/send"

    object MODEL {
        const val id = "id"
        const val body = "body"
        const val title = "title"
        const val userId = "userId"
    }

    object ID {
        const val DEFAULT_NOTIFICATION_CHANNEL = "FIND_NOTIFICATION_CHANNEL"
        const val TASK_NOTIFICATION_CHANNEL = "FIND_LOCATION_CHANNEL"
        const val GROUP_TASK_NOTIFICATION_CHANNEL = "FIND_GROUP_LOCATION_NOTIFICATION_CHANNEL"

    }

    object GROUP {
        const val TASK_NOTIFICATION_CHANNEL = "Task"
    }

    object CHANNEL {
        const val GROUP_TASK_NOTIFICATION_CHANNEL = "Task Notification"
    }

    object DESCRIPTION {
        const val TASK_NOTIFICATION_CHANNEL = "Task channel description"
        const val GROUP_TASK_SERVICE_NOTIFICATION_CHANNEL = "Task channel description"
    }
}