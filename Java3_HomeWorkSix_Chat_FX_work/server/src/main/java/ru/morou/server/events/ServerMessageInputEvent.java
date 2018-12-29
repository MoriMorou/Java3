package ru.morou.server.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import ru.morou.server.model.Package;

import javax.enterprise.event.Event;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;
import java.net.Socket;

public class ServerMessageInputEvent extends ServerMessageEvent {

    public ServerMessageInputEvent(@NotNull Socket socket, @NotNull String message){
        super(socket, message);
    }
}
