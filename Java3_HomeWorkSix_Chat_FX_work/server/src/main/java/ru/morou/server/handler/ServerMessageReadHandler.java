package ru.morou.server.handler;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.morou.server.events.ServerConnectionEvent;
import ru.morou.server.events.ServerMessageInputEvent;
import ru.morou.server.events.ServerMessageReadEvent;
import ru.morou.server.service.ConnectionService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.DataInputStream;
import java.io.InputStream;

@ApplicationScoped
public class ServerMessageReadHandler {

    @Inject
    private ConnectionService connectionService;

    @Inject
    private Event<ServerMessageReadEvent> serverMessageReadEvent;

    @Inject
    private Event<ServerMessageInputEvent> serverMessageInputEvent;

    public void handler(@Observes final ServerMessageReadEvent event){
        System.out.println("ServerMessageReadHandler");
        try {
            @NotNull final InputStream inputStream = event.getSocket().getInputSream();
            @NotNull final DataInputStream in = new DataInputStream(inputStream);
            @NotNull final String message = in.readUTF();
            serverMessageReadEvent.fireAsync(new ServerMessageReadEvent(event.getSocket()));
            serverMessageInputEvent.fireAsync(new ServerMessageInputEvent(event.getSocket(), message));
        } catch (@NotNull final Exception e){
            connectionService.remove(event.getSocket());
        }
    }
}