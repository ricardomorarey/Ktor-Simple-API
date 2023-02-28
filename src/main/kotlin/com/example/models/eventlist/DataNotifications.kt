package com.example.models.eventlist

import kotlinx.serialization.Serializable

@Serializable
data class DataNotifications(
    val brand: String,
    val date: String,
    val description: String,
    val device: String,
    val type: String,
    val device_type: String,
    val channel: Int,
    val id: String
)