package ru.morimorou.java.Basis.Ex5_Fanalization.ForField;

import java.util.UUID;

public class Car {

    final public String id = UUID.randomUUID().toString();

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                '}';
    }

    public static void main(String[] args) {
        final Car car = new Car();
//        car.id = "22";  тут Ошибка
        System.out.println(car);
    }
}
