package com.bydemes.tss.retrofit.response.firebase

import kotlinx.serialization.Serializable

@Serializable
data class ResponseDeleteTokenFCM(
    val `data`: DataDeleteFcmToken,
    val status: String
)