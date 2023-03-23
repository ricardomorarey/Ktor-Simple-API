package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*

val hostPort = "192.168.0.19:8080"
fun main() {
    embeddedServer(
        Netty,
        port = 8080,
        host = "192.168.0.19",
        module = Application::module
    )
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
}
