package ru.morimorou.java.Basis.Ex7_Encapsulation.Test;

import ru.morimorou.java.Basis.Ex7_Encapsulation.Car.Car;
import ru.morimorou.java.Basis.Ex7_Encapsulation.Cargo.Cargo;
import ru.morimorou.java.Basis.Ex7_Encapsulation.Cargo.CargoLadge;

public class Main {

    public static void main(String[] args) {

        final Car car = new Car();
//        car.go();  метод privet
//        car.id = "1"; переменная privet

        final Cargo cargo = new Cargo();
        cargo.id = "11";
        cargo.go();

        final CargoLadge cargoLadge = new CargoLadge();
        cargoLadge.id = "13";
        cargoLadge.go();


    }
}
