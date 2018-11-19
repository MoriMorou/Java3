package ru.morimorou.java.Theard.Ex7_ReentrantLock;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex7_ReentrantLock {

    @Test
    public void test() throws Exception{
        final int theardCount = 5;
        final ExecutorService service= Executors.newCachedThreadPool();
        final Task task = new LockUnlockDemo();
        for (int i = 0; i < theardCount; i++) {
            service.execute(new Worker(task));
        }
        service.awaitTermination(5, TimeUnit.SECONDS);
    }
}
