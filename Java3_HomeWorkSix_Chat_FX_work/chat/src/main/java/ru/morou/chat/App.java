package ru.morou.chat;

import ru.morou.chat.impl.ChatClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        final ChatClient client = new ChatClient();
        client.run();
    }
}
