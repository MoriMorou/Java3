package ru.morimorou.java.Basis.Ex5_Fanalization.ForMeth;

public class Cargo extends Car {

    @Override
    public void stop() {
        super.stop();
        System.out.println("Stop, stop");
    }

//    public void go() {    тут Ошибка
//
//    }
}
