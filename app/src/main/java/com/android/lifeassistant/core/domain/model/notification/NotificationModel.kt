package com.android.lifeassistant.core.domain.model.notification

import kotlinx.serialization.Serializable

@Serializable
data class NotificationModel(
    val to: String? = null,
    val data: DataModel? = null
)

@Serializable
data class DataModel(
    val id: Int,
    val body: String,
    val title: String,
    val userId : String,
)


