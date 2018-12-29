package ru.morou.server.handler;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.morou.server.api.ConnectionService;
import ru.morou.server.events.ServerBroadcastEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;
import java.net.Socket;
import java.sql.Connection;

@ApplicationScoped
public class ServerBroadcastHandler {

    @Inject
    private ConnectionService connectionService;

    public void handler(@ObservesAsync ServerBroadcastEvent event){
        @NotNull final Socket socket = event.getSocket();
        @Nullable final Connection connection = connectionService.get(socket);
        if (connection == null) return;;
        @Nullable final String login = connection.getLogin();
        if (login == null || login.isEmpty()) return;;
        @NotNull final String message = event.getMessage();
        for (final Connection item: connectionService.connections()) {
            connectionService.sendMessage(item, login, message);
        }
    }
}
