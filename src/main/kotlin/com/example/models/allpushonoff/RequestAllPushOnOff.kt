package com.bydemes.scc.retrofit.request.allpushonoff

import kotlinx.serialization.Serializable

@Serializable
data class RequestAllPushOnOff(
    val active_notifications: Boolean
)