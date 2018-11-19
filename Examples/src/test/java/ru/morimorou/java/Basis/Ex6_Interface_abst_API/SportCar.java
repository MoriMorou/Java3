package ru.morimorou.java.Basis.Ex6_Interface_abst_API;

public class SportCar implements Car {
    @Override
    public void go() {
        System.out.println("Trin trin....");
    }

    public void start() {
        System.out.println("Start!");
    }
}
