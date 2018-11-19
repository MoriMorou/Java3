package ru.morimorou.java.Basis.Ex4_Override;

import java.util.UUID;

public class Car {

// Все поля кроме приватных наследуются от рожительского класса
    String id = UUID.randomUUID().toString();

    public void go() {
        System.out.println("Go...");
    }
    public void print() {
        System.out.println("I am car...");
        System.out.println("My id is " + id);
    }

}
