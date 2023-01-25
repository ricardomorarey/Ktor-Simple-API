package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Tokens(val acces: String, val refresh: String)
