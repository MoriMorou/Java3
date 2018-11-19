package ru.morou.chat.api;

import ru.morou.chat.ChatConfiguration;

import java.util.concurrent.ExecutorService;

/**
 * Hello world!
 *
 */

public interface ChatApp extends Runnable {
    ExecutorService getExecutor();
    ChatConfiguration getConfiguration();
    void run();
}
