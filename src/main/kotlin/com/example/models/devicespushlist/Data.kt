package com.example.models.devicespushlist

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val active_until: String,
    var push: Boolean,
    val uuid: String
)