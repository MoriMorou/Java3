package ru.morimorou.java.Theard.Ex7_ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class LockUnlockDemo implements Task {

    final ReentrantLock reentrantLock = new ReentrantLock();


    // работает с одним потоком (многофункциональный с разричными функциями доступа для выстраивания сложной
    // логики приложения, программы)
    @Override
    public void performTask() {
        System.out.println(Thread.currentThread().getName() + ": perform a task");
        reentrantLock.lock();;
        try {
            System.out.println(Thread.currentThread().getName() + ": Lock acquired");
            System.out.println("Processing...");
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + ": Lock released");
            reentrantLock.unlock();
        }
    }
}
