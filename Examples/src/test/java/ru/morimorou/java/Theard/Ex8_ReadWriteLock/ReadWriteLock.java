package ru.morimorou.java.Theard.Ex8_ReadWriteLock;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadWriteLock {

    private final class Client implements Runnable {

        private final Shop shop;
        private final ExecutorService executorService;

        private Client(final ExecutorService executorService, final Shop shop) {
            this.executorService = executorService;
            this.shop = shop;
        }

        @Override
        public void run() {
            shop.buy();
            executorService.execute(new Client(executorService, shop));
        }
    }

    private final class Supplier implements Runnable {

        private final Shop shop;
        private final ExecutorService executorService;


        private Supplier(final ExecutorService executorService, final Shop shop) {
            this.executorService = executorService;
            this.shop = shop;
        }


        @Override
        public void run() {
            shop.add(new Product());
            executorService.execute(new Supplier(executorService, shop));
        }
    }

    @Test
    public void test() {
        final Shop shop = new Shop();
        final ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Supplier(executorService, shop));
        executorService.submit(new Client(executorService, shop));
    }
}
