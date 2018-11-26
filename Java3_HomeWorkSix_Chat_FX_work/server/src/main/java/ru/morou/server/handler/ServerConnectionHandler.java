package ru.morou.server.handler;

import lombok.SneakyThrows;
import ru.morou.server.api.Server;
import ru.morou.server.events.ServerConnectionEvent;
import ru.morou.server.events.ServerMessageReadEvent;
import ru.morou.server.service.ConnectionService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.net.Socket;

@ApplicationScoped
public class ServerConnectionHandler {

    @Inject
    private Server server;

    @Inject
    private ConnectionService connectionService;

    @Inject
    private Event<ServerConnectionEvent> serverConnectionEvent;

    @Inject
    private Event<ServerMessageReadEvent> serverMessageReadEvent;

    @SneakyThrows
    public void sync(@Observes final ServerConnectionEvent event){
        System.out.println("ServerConnectionHandler");
        final Socket socket = server.getServerSocket().accept();
        connectionService.add(socket);
        serverMessageReadEvent.fireAsync(new ServerMessageReadEvent(socket));
        serverConnectionEvent.fire(new ServerConnectionEvent());

    }
}
