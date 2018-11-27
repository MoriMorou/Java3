package ru.morou.server.handler;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import ru.morou.server.events.ServerMessageInputEvent;
import ru.morou.server.events.ServerMessageReadEvent;
import ru.morou.server.events.ServerPingEvent;
import ru.morou.server.model.Package;
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

    @Inject
    private Event<ServerPingEvent> serverPingEvent;


    @SneakyThrows
    public void observe(@ObservesAsync final ServerMessageInputEvent event) {
        System.out.println("ServerMessageInputHandler");
        @NotNull final Socket socket = event.getSocket();
        @NotNull final String message = event.getMessage();
        System.out.println(message);
        @NotNull final ObjectMapper objectMapper = new ObjectMapper();
        @NotNull final Package packet = objectMapper.readValue(message, Package.class);

        switch (packet.getType()){

            case PING:
                serverPingEvent.fireAsync(new ServerPingEvent(socket, message));
                break;

            case REGISTRY:
                serverRegistryEvent.fireAsync(new ServerRegistryEvent(socket, message));
                break;

            case LOGIN:
                serverLoginEvent.fireAsync(new ServerLoginEvent(socket, message));
                break;

            case BROADCAST:
                serverBroadcastEvent.fireAsync(new ServerBroadcastEvent(socket, message));
                break;

            case LOGOUT:
                serverLogoutEvent.fireAsync(new ServerLogoutEvent(socket, message));
                break;
        }
    }
}
