package ru.morou.chat;

import ru.morou.chat.task.AbstractChatTask;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

public interface Client{
    ExecutorService getExecutor();
    ChatConfiguration getConfiguration();
    Socket getSocket();
    DataOutputStream getOut();
    DataInputStream getIn();
    void broadcast(String message);
    void run();
    void run(AbstractChatTask task);
    void exit();
}
