package com.bydemes.scc.retrofit.response.authopt

import kotlinx.serialization.Serializable

@Serializable
data class ResponseAuthOpt(
    val `data`: String,
    val status: String
)