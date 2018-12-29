package ru.morou.server.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.Socket;
import java.sql.Connection;
import java.util.List;

public interface ConnectionService {

    @NotNull
    List<Connection> connections();

    @Nullable
    Connection get(final Socket socket);

    void add(@Nullable Socket socket);
    void remove(@Nullable Socket socket);
    void setLogin(@Nullable Socket socket, @Nullable String login);
    void sendResult(@Nullable Socket socket, @Nullable Boolean result);
    void sendMessage(@Nullable Connection connection, @Nullable String login, @Nullable String message);
}
