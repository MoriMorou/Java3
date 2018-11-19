package ru.morimorou.java.Basis.Ex4_Override;

public class Main {

    public static void main(String[] args) {
        final Car car = new Car();
        car.print();
        car.go();

        System.out.println("__________");

        final Cargo cargo = new Cargo();
        cargo.print();
        cargo.go();
    }


}
