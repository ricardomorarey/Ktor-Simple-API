package com.bydemes.tss.retrofit.response.firebase

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val active: Boolean,
    val date_created: String,
    val device_id: String,
    val name: String,
    val registration_id: String,
    val type: String
)