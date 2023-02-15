package com.bydemes.scc.retrofit.response.allpushonoff

import kotlinx.serialization.Serializable

@Serializable
data class ResponseAllPushOnOff(
    val `data`: Data,
    val status: String
)