package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class DataLogin(
    val access: String,
    val refresh: String
)