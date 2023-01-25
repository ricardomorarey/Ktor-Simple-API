package com.bydemes.tss.retrofit.response.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val `data`: DataLogin,
    val status: String
)