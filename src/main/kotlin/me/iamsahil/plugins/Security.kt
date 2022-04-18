package me.iamsahil.plugins

import io.ktor.sessions.*
import io.ktor.application.*
import io.ktor.util.*
import me.iamsahil.session.ChatSession

fun Application.configureSecurity() {
    install(Sessions) {
        cookie<ChatSession>("SESSION")
    }

    intercept(ApplicationCallPipeline.Features) {
        if(call.sessions.get<ChatSession>() == null) {
            val username = call.parameters["username"] ?: "Guest"
            call.sessions.set(ChatSession(username, generateNonce()))
        }
    }
}