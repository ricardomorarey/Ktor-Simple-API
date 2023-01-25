package com.bydemes.scc.activities.main.ui.devices

import kotlinx.serialization.Serializable

@Serializable
data class DeviceItem(

    val name: String,
    val date: String,
    val push: Boolean,
    val subs: String,
    val p2p: String?,
    val host: String?,
    val serial: String,
    val type: String
)
