package ru.morou.server.service;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.enterprise.context.ApplicationScoped;
import java.net.Socket;
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
        if(socket == null) return;;
        @NotNull final Connection connection = new Connection(socket);
        connections.add(connection);
        System.out.println("added connection with id " + connection.getId() + "...");
    }


}
