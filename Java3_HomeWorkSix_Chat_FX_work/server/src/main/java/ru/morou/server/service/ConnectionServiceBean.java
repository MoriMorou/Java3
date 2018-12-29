package ru.morou.server.service;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.morou.server.api.ConnectionService;

import javax.enterprise.context.ApplicationScoped;
import java.net.Socket;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@ApplicationScoped
public class ConnectionServiceBean implements ConnectionService {

    @NotNull
    private final List<Connection> connections = new ArrayList<>();

    @NotNull
    public List<Connection> connections() {
        return connections;
    }

    @Override
    public void add(@Nullable final Socket socket) {
        if (socket == null) return;;
        @NotNull final Connection connection = new Connection(socket);
        connections.add(connection);
        System.out.println("added connection with id " + connection.getId() + "...");
    }

    @Nullable
    @Override
    public Connection get(@Nullable final Socket socket) {
        if (socket==null) return null;
        for (final Connection connection: connections) {
            if (connection.getSocket().equals(socket)) return connection;
        }
        return null;
    }

    @Override
    public void setLogin(@Nullable final Socket socket, @Nullable final String login) {
        if (login == null || login.isEmpty()) return;
        @Nullable final Connection connection = get(socket);
        if (connection == null) return;
        connection.setLogin(login);
        System.out.println("Session created for Login " +login);
    }

    @Override
    public void remove(@Nullable final Socket socket){
        if (socket == null) return;;
        final Connection connection = get(socket);
        if (connection == null) return;

    }

}
