package com.bydemes.scc.retrofit.response.eventlist

import kotlinx.serialization.Serializable

@Serializable
data class ResponseEventList(
    val `data`: List<DataNotifications>,
    val status: String
)