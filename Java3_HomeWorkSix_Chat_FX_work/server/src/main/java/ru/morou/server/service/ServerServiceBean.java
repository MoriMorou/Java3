package ru.morou.server.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import ru.morou.server.api.Server;
import ru.morou.server.events.ServerConnectionEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;


@Getter
@NoArgsConstructor
@ApplicationScoped
public class ServerServiceBean implements Server {

    @Inject
    private ServerConfiguration config;

    @Inject
    private Event<ServerConnectionEvent> serverConnectionEvent;

    private ServerSocket serverSocket;


    @Override
    @SneakyThrows
    public void run(){
        serverSocket = new ServerSocket(config.getPort());
        serverConnectionEvent.fire(new ServerConnectionEvent());
    }
}
