package ru.morou.chat.handler;

import org.jetbrains.annotations.NotNull;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientMessageInputHandler {

    @NotNull
    private final static String CMD_Exit = "exit";

    @NotNull
    private final static String CMD_Login = "login";

    @NotNull
    private final static String CMD_Ping = "ping";

    int[] myArray = new int[10];

}
