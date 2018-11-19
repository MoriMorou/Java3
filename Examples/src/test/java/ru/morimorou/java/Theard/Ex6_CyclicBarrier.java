package ru.morimorou.java.Theard;

import org.junit.Test;

import java.util.concurrent.*;

public class Ex6_CyclicBarrier {

    private class Task extends Thread {

        private final CyclicBarrier cyclicBarrier;

        private Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("Поток "+ Thread.currentThread().getId() + " готовится");
                Thread.sleep(100 + (int) (2000 * Math.random()));
                System.out.println("Поток "+ Thread.currentThread().getId() + " готов");
                cyclicBarrier.await();
                System.out.println("Поток "+ Thread.currentThread().getId() + " завершился");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    // смысл такой - ждем последнего (или определенный минимум) и только потом стартуем
    @Test
    public void test(){
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        final ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Task(cyclicBarrier));
        }
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
