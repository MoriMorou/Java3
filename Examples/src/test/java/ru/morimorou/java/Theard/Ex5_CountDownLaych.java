package ru.morimorou.java.Theard;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex5_CountDownLaych {

    private class Task extends Thread {

        private final CountDownLatch countDownLatch;

        private Task(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println("Поток "+ Thread.currentThread().getId() + " запуск");
                countDownLatch.await();
                System.out.println("Поток "+ Thread.currentThread().getId() + " готов");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test(){
        final int count = 3;  // отсчет до старта
        final CountDownLatch countDownLatch = new CountDownLatch(count);
        final ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Task(countDownLatch));
        }
        System.out.println("Time for start...");
        for (int i = 0; i < count; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(count-1);
            countDownLatch.countDown();
        }
    }
}
