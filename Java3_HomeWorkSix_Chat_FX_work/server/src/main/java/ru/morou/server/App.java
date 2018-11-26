package ru.morou.server;

import ru.morou.server.limp.ChatServer;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args ) {
        final ChatServer server = new ChatServer();
        server.run();
    }
}
