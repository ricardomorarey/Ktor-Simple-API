package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val `data`: DataLogin,
    val status: String
)