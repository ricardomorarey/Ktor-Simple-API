package com.bydemes.scc.retrofit.response.infouserme

import kotlinx.serialization.Serializable

@Serializable
data class ResponseInfoUserMe(
    val `data`: Data,
    val status: String
)