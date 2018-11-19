package ru.morimorou.java.Theard;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Ex4_Semaphore {

    private final class Task extends Thread {

        private final Semaphore semaphore;

        private Task(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                System.out.println("Поток "+ Thread.currentThread().getId() + " перед семафором");
                semaphore.acquire();  // выдача разрешений
                System.out.println("Поток "+ Thread.currentThread().getId() + " плучил доступ");
                Thread.sleep(500);
                System.out.println("Поток "+ Thread.currentThread().getId() + " освободил ресурс");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test(){
        final ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(2);  // объем разрешений
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Task(semaphore));
        }
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
