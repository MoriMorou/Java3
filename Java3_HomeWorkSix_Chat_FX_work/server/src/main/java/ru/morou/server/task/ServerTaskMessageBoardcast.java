package ru.morou.server.task;

import ru.morou.server.model.Connection;
import ru.morou.server.api.Server;

public class ServerTaskMessageBoardcast extends AbstractServerTask {

    private String message;

    public ServerTaskMessageBoardcast(Server server, String message) {
        super(server);
        this.message = message;
    }

    @Override
    public void run(){
        for (final Connection connection: server.connections()) {
            connection.send(message);
        }
    }
}
