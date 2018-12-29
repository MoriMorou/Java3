package ru.morou.chat.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import ru.morou.chat.ChatConfiguration;
import ru.morou.chat.api.Client;
import ru.morou.chat.event.ClientMessageInputEvent;
import ru.morou.chat.event.ClientMessageReadEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;


@Getter
@Setter
@NoArgsConstructor
@ApplicationScoped
public class ClientServer implements Client {

    @Inject
    private Event<ClientMessageReadEvent> clientMessageReadEvent;

    @Inject
    private Event<ClientMessageInputEvent> clientMessageInputEvent;

    @Inject
    private ChatConfiguration chatConfiguration;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    @Override
    @SneakyThrows
    public void run() {
        final String host = chatConfiguration.getHost();
        final Integer port = chatConfiguration.getPort();
        socket = new Socket(host, port);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        clientMessageReadEvent.fireAsync(new ClientMessageReadEvent());
        clientMessageInputEvent.fire(new ClientMessageInputEvent());
    }

    @Override
    @SneakyThrows
    public void send(String message) {
        out.writeUTF(message);
    }

    @Override
    @SneakyThrows
    public void exit() {
        socket.close();
        System.out.println("Chat client disconnected");
        System.exit(0);
    }
}
