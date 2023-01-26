package com.bydemes.scc.retrofit.response.devicedetail

import kotlinx.serialization.Serializable

@Serializable
data class ResponseDeviceDetail(
    val `data`: Data,
    val status: String
)