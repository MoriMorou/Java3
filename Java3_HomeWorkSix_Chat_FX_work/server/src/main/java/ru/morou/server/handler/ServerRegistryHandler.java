package ru.morou.server.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import ru.morou.server.api.ConnectionService;
import ru.morou.server.api.UserService;
import ru.morou.server.events.ServerRegistryEvent;
import ru.morou.server.model.PackageRegistry;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;
import java.net.Socket;

@ApplicationScoped
public class ServerRegistryHandler {

    @Inject
    private UserService userService;

    @Inject
    private ConnectionService connectionService;

    @SneakyThrows
    public void observe(@ObservesAsync final ServerRegistryEvent event) {
        @NotNull final Socket socket = event.getSocket();
        @NotNull final String message = event.getMessage();
        @NotNull final ObjectMapper objectMapper = new ObjectMapper();
        @NotNull final PackageRegistry packageRegistry = objectMapper.readValue(message, PackageRegistry.class);
        final boolean result = userService.registration(packageRegistry.getLogin(), packageRegistry.getPassword());
        connectionService.sendResult(socket, result);
    }

}
