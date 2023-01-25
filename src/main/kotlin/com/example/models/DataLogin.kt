package com.bydemes.tss.retrofit.response.login

import kotlinx.serialization.Serializable

@Serializable
data class DataLogin(
    val access: String,
    val refresh: String
)