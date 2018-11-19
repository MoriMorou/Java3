package ru.morimorou.java.Basis.Ex6_Interface_abst_API;

abstract class CargoLarge_big implements Car{

    // абстрактный класс может содержать методы и абстракные и нет
    @Override
    public void go() {
        System.out.println("Go....");
    }

    abstract void stop();

    public static void start(){

    }
}
