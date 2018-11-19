package ru.morimorou.java.Basis.Ex6_Interface_abst_API;

public class Cargo implements Car{
    @Override
    public void go() {
        System.out.println("Goooo....");
    }

    public void stop() {
        System.out.println("Stop!!!");
    }
}
