package ru.morou.server.events;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.net.Socket;

@Getter
public class ServerMessageEvent {

    @NotNull
    private final Socket socket;

    @NotNull
    private final String message;

    public ServerMessageEvent(@NotNull Socket socket, @NotNull String message) {
        this.socket = socket;
        this.message = message;
    }
}
