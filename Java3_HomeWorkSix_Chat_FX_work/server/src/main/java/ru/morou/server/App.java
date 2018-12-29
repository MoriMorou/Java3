package ru.morou.server;

import ru.morou.server.limp.ChatServer;
import ru.morou.server.service.ServerServiceBean;

import javax.enterprise.inject.se.SeContainerInitializer;
import javax.enterprise.inject.spi.CDI;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args ) {
//        SeContainerInitializer.newInstance().addProperty(App.class).initialize();
//        CDI.current().select(ServerServiceBean.class).get();
        final ChatServer server = new ChatServer();
        server.run();
    }
}
