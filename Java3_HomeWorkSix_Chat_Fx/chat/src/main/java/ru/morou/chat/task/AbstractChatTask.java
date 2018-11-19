package ru.morou.chat.task;

import ru.morou.chat.Client;

public abstract class AbstractChatTask extends Thread {
    protected Client client;
    protected AbstractChatTask(Client client) {
        this.client = client;
    }
}
