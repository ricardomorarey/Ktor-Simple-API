package com.example.models.devices

import kotlinx.serialization.Serializable

@Serializable
data class ResponseDevices(
    val `data`: List<DataDevices>,
    val status: String
)