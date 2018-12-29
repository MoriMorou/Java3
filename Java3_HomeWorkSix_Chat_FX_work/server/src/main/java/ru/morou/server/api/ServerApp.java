package ru.morou.server.api;

import ru.morou.server.service.ServerConfiguration;
import java.util.concurrent.ExecutorService;

public interface ServerApp extends Runnable {
//    ExecutorService getExecutor();
//    ServerConfiguration getConfiguration();
    void run();
}
