package com.bydemes.scc.retrofit.response.urlbaseserverpc

import kotlinx.serialization.Serializable

@Serializable
data class ResponseUrlBaseServerPc(
    val `data`: DataUrlBaseServer,
    val status: String
)