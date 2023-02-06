package com.example.models.devicespushlist

import kotlinx.serialization.Serializable

@Serializable
data class ResponseDevicesPushList(
    val `data`: List<Data>,
    val status: String
)