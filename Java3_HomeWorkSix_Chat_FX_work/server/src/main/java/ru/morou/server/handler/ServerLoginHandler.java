package ru.morou.server.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import ru.morou.server.api.ConnectionService;
import ru.morou.server.api.UserService;
import ru.morou.server.events.ServerLoginEvent;
import ru.morou.server.model.PackageLogin;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;
import java.net.Socket;

@ApplicationScoped
public class ServerLoginHandler {

    @Inject
    private UserService userService;

    @Inject
    private ConnectionService connectionService;

    @SneakyThrows
    public void handler(@ObservesAsync final ServerLoginEvent event){
        @NotNull final Socket socket = event.getSocket();
        @NotNull final String message = event.getMessage();
        @NotNull final ObjectMapper objectMapper = new ObjectMapper();
        @NotNull final PackageLogin packages = objectMapper.readValue(message, PackageLogin.class);
        boolean check = userService.check(packages.getLogin(), packages.getPassword());
        if (check) connectionService.setLogin(socket, packages.getLogin());
        if (!check) System.out.println("Incorrect passwork for Login " + packages.getLogin());
        connectionService.sendResult(socket, check);
    }
}
