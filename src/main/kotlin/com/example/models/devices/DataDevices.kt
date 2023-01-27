package com.bydemes.scc.retrofit.response.devices

import kotlinx.serialization.Serializable

@Serializable
data class DataDevices(
    val description: String,
    val brand: String,
    val connectionType: String,
    val host: String,
    val id: String,
    val port: String,
    val sn: String,
    val subs: String,
    val type: String,
    val user: String,
    val uuid: String,
    val channels: List<Int>
)
