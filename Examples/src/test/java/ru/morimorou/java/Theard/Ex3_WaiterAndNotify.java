package ru.morimorou.java.Theard;

import org.junit.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex3_WaiterAndNotify {

    private static class Waiter extends Thread {

        private final Object moritor;

        private Waiter(Object monitor) {
            this.moritor = monitor;
        }

        @Override
        public void run() {
            synchronized (moritor) {
                System.out.println(Thread.currentThread().getId() + ":" + "call wait");
                try {
                    moritor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + ":" + "after notify");
            }
        }

        private static class NotifierSingle extends Thread {

            private final Object moritor;

            private NotifierSingle(Object monitor) {
                this.moritor = monitor;
            }

            @Override
            public void run() {
                synchronized (moritor) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getId() + ":" + "call notify");
                    moritor.notify();
                }
            }
        }

        private static class NotifierMany extends Thread {

            private final Object moritor;

            private NotifierMany(Object monitor) {
                this.moritor = monitor;
            }


            @Override
            public void run() {
                synchronized (moritor) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getId() + ":" + "call notifyAll");
                    moritor.notifyAll();
                }
            }
        }
    }

    // все потоки засыпают и потом один поизвольный поток просыпаются
    @Test
    public void testSingle(){
        final Object monitor = new Object();
        final ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Waiter(monitor));
        executorService.submit(new Waiter(monitor));
        executorService.submit(new Waiter(monitor));
        executorService.submit(new Waiter.NotifierSingle(monitor));
    }

    // все потоки засыпают и потом все потоки просыпаются
    @Test
    public void testMany(){
        final Object monitor = new Object();
        final ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Waiter(monitor));
        executorService.submit(new Waiter(monitor));
        executorService.submit(new Waiter(monitor));
        executorService.submit(new Waiter.NotifierMany(monitor));
    }
}
