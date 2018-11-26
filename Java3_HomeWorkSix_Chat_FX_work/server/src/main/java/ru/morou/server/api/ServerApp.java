package ru.morou.server.api;

import java.util.concurrent.ExecutorService;

public interface ServerApp extends Runnable {
    ExecutorService getExecutor();
    ServerConfiguration getConfiguration();
    void run();
}
