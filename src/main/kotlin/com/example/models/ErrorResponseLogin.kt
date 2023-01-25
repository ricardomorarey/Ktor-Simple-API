package com.bydemes.tss.retrofit.response.login

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponseLogin(
    val `data`: DataErrorLogin,
    val status: String
)