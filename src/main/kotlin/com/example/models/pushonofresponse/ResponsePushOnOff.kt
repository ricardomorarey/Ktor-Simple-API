package com.example.models.pushonofresponse

import kotlinx.serialization.Serializable

@Serializable

data class ResponsePushOnOff(
    val `data`: Data,
    val status: String
)