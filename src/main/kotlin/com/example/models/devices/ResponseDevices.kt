package com.bydemes.scc.retrofit.response.devices

import kotlinx.serialization.Serializable

@Serializable
data class ResponseDevices(
    val `data`: List<DataDevices>,
    val status: String
)