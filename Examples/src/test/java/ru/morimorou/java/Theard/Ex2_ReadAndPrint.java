package ru.morimorou.java.Theard;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex2_ReadAndPrint {

    private static final int MAX = 20;
    private Integer value = 0;

    private synchronized void print() {
        for (int i = 0; i < MAX; i++){
            System.out.println("= PRINT: " + value);
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void increment() {
        for (int i = 0; i < MAX; i++){
            notify();
            System.out.println(": BEFORE: " + value);
            value++;
            System.out.println(": AFTER : " + value);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test() throws  Exception{
        final ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(this::print);
        executorService.submit(this::increment).get();
    }

    @Test
    public void testMany() throws  Exception{
        final ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(this::print);
        executorService.submit(this::increment);
        executorService.submit(this::print);
        executorService.submit(this::increment).get();
    }
}
