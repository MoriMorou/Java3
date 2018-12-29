package ru.morou.server.handler;

import ru.morou.server.api.ConnectionService;
import ru.morou.server.events.ServerPingEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;
import java.sql.Connection;

@ApplicationScoped
public class ServerPingHandler {

    @Inject
    private ConnectionService connectionService;

    public void handler(@ObservesAsync final ServerPingEvent event) {
        final Connection connection = connectionService.get(event.getSocket());
        if (connection == null) return;
        System.out.println("Ping from connection with ID " + connection.getId());
        connectionService.sendResult(event.getSocket(), true);
    }
}
