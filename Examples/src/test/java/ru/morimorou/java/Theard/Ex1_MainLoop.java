package ru.morimorou.java.Theard;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex1_MainLoop {

    private static class Task implements Runnable {

        private ExecutorService executorService;

        private Task(ExecutorService executorService) {
            this.executorService = executorService;
        }

        @Override
        public void run() {
            System.out.println(new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.submit(new Task(executorService));
        }
    }

    private static class Exit implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Ex1_MainLoop.exit();
        }
    }

    public synchronized static void main(String[] args) throws Exception {
        final ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Exit());
        executorService.submit(new Task(executorService));
        System.out.println("TestMainLoop.class.wait();");
        Ex1_MainLoop.class.wait();  // Внимание wait может проснуться (нужно его в цикл засунуть)
        System.out.println("TestMainLoop.class.notify();");
        executorService.shutdown();
    }

    private synchronized static void exit() {
        Ex1_MainLoop.class.notify();
    }
}