package ru.morou.server.handler;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import ru.morou.server.events.ServerMessageInputEvent;
import ru.morou.server.events.ServerMessageReadEvent;
import ru.morou.server.service.ConnectionService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;
import java.net.Socket;

@ApplicationScoped
public class ServerMessageInputHandler {

    @Inject
    private ConnectionService connectionService;

    @Inject
    private Event<ServerMessageReadEvent> serverMessageReadEvent;

    @Inject
    private Event<ServerMessageInputEvent> serverMessageInputEvent;

    @SneakyThrows
    public void observe(@ObservesAsync final ServerMessageInputEvent event) {
        System.out.println("ServerMessageInputHandler");
        @NotNull final Socket socket = event.getSocket();
        @NotNull final String message = event.getMessage();
        System.out.println(message);
        
    }
}
