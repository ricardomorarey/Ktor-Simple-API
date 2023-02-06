package com.example.models.eventlist

import kotlinx.serialization.Serializable

@Serializable
data class ResponseEventList(
    val `data`: List<DataNotifications>,
    val status: String
)