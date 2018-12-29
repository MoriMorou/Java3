package ru.morou.server.events;


import org.jetbrains.annotations.NotNull;
import ru.morou.server.handler.ServerRegistryHandler;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerRegistryEvent extends ServerRegistryHandler {

    public ServerRegistryEvent(@NotNull Socket socket, @NotNull String message) {
    }

    public Socket getSocket() {
    }

    public String getMessage() {
    }
}
