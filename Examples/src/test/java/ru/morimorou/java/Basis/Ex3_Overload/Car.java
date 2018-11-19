package ru.morimorou.java.Basis.Ex3_Overload;

public class Car {

    private void go() {
        System.out.println("Car is going...");
    }

    private void go(Long londitude, Long latitude) {
        System.out.println("Car to geo point...");
    }

    public static void main(String[] args) {
        final Car car = new Car();
        car.go();
        car.go(213145L, 233423L);
    }
}
