package com.example.models.pushonofrequest

import kotlinx.serialization.Serializable

@Serializable
data class RequestPushOnOf(
    val active_until: String?,
    val push: Boolean
)