package com.example.models.devicespushlist

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val active_until: String,
    val push: Boolean,
    val uuid: String
)