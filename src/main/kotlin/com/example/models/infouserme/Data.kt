package com.bydemes.scc.retrofit.response.infouserme

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val current_otp: String,
    val name: String,
    val devices: List<String>,
    val push_active: Boolean,
    val uuid: String
)