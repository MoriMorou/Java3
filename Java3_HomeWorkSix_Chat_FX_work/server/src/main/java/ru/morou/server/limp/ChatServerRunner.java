package ru.morou.server.limp;

import lombok.Getter;
import lombok.SneakyThrows;
import ru.morou.server.api.ServerConfiguration;
import ru.morou.server.service.ServerServiceBean;
import ru.morou.server.api.Server;
import ru.morou.server.task.AbstractServerTask;
import ru.morou.server.task.ServerTaskConnection;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Getter
public class ChatServerRunner implements Server {

    private final ServerConfiguration configuration;
    private final ExecutorService executor;
    private final ServerServiceBean connectionService;
    private ServerSocket serverSocket;

    public ChatServerRunner(ServerConfiguration serverConfiguration, ExecutorService executorService) {
        this.connectionService = new ServerServiceBean(this);
        this.configuration = serverConfiguration;
        this.executor = executorService;
    }

    @Override
    @SneakyThrows
    public void run() {
        serverSocket = new ServerSocket(configuration.getPort());
        run(new ServerTaskConnection(this));
    }

    @Override
    public void run(AbstractServerTask task){
        executor.submit(task);
    }

    @Override
    public void add(Socket socket) {
        connectionService.add(socket);
    }

    @Override
    public List<Connection> connections(){
        return connectionService.connections();
    }

    @Override
    public void remove(Socket socket) {
        connectionService.remove(socket);
    }

    public static void main(String[] args) {
        final ChatServer server = new ChatServer();
    }

}
