package com.bydemes.tss.retrofit.response.firebase

import kotlinx.serialization.Serializable

@Serializable
data class ResponseTokenFCM(
    val `data`: Data,
    val status: String
)