package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class LogoutResponse (
    val status: String
)