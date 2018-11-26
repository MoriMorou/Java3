package ru.morou.server.service;


import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.SneakyThrows;
import ru.morou.server.api.Server;
import ru.morou.server.api.ServerConfiguration;
import ru.morou.server.events.ServerConnectionEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.net.ServerSocket;

@Getter
@NoArgsConstructor
@ApplicationScoped
public class ServerServiceBean implements Server {

    @Inject
    private ServerConfiguration serverConfiguration;

    @Inject
    private Event<ServerConnectionEvent> serverConnectionEvent;

    private ServerSocket serverSocket;

    @Override
    @SneakyThrows
    public void run(){
        serverSocket = new ServerSocket(serverConfiguration.getPort());
        ServerConnectionEvent.fire(new ServerConnectionEvent());
    }
}
