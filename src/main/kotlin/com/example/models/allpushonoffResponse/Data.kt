package com.bydemes.scc.retrofit.response.allpushonoff

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val active: Boolean,
    val current_otp: String,
    val description: String,
    val devices: List<String>,
    val push_active: Boolean,
    val uuid: String
)