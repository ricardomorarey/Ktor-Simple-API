package com.bydemes.tss.retrofit.response.login

import kotlinx.serialization.Serializable

@Serializable
data class DataErrorLogin(
    val code: String,
    val detail: String
)