package me.iamsahil.plugins

import io.ktor.routing.*
import io.ktor.application.*
import me.iamsahil.room.RoomController
import me.iamsahil.routes.chatSocket
import me.iamsahil.routes.getAllMessages
import org.koin.ktor.ext.inject

fun Application.configureRouting() {

    val roomController by inject<RoomController>()
    install(Routing) {
        chatSocket(roomController)
        getAllMessages(roomController)
    }
}
