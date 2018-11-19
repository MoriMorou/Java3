package ru.morimorou.java.Theard.Ex8_ReadWriteLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Shop {

    private final List<Product> products = new ArrayList<>();
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock lockRead = readWriteLock.readLock();
    private final Lock lockWrite = readWriteLock.writeLock();

    public void shop(){
        lockRead.lock();  //блокировка на чтение
        System.out.println(products);
        lockRead.unlock();
    }

    public Product buy() {
        Product product = null;
        lockWrite.lock();
        if (!products.isEmpty()) {
            product = products.get(0);
            products.remove(product);
            System.out.println("buy: " + product);
        }
        lockWrite.unlock();
        return product;
    }

    public void add(final Product product){
        if (product == null) {
            return;
        }
        lockWrite.lock();
        products.add(product);
        System.out.println("add: " + product);
        lockWrite.unlock();
    }
}
