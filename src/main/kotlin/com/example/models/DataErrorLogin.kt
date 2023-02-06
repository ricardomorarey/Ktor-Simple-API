package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class DataErrorLogin(
    val code: String,
    val detail: String
)