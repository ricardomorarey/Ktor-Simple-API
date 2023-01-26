package com.bydemes.scc.retrofit.response.devicedetail

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val brand: String,
    val channels: List<Int>,
    val conecctionType: String,
    val description: String,
    val host: String,
    val id: String,
    val port: String,
    val sn: String,
    val subs: String,
    val type: String,
    val user: String,
    val uuid: String
)