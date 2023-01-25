package com.bydemes.tss.retrofit.response.login

import kotlinx.serialization.Serializable

@Serializable
data class LogoutResponse (
    val status: String
)