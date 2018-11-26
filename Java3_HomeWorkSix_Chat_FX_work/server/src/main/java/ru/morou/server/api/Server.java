package ru.morou.server.api;

import org.jetbrains.annotations.NotNull;

import java.net.ServerSocket;

public interface Server extends ServerApp {

    @NotNull
    ServerSocket getServerSocket();

    void run();
}
