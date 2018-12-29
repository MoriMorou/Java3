package ru.morou.chat.api;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public interface Client extends ChatApp{
    Socket getSocket();
    DataOutputStream getOut();
    DataInputStream getIn();
    void send(String message);
    void run();
    void exit();
}
