package ru.morimorou.java.Basis.Ex2_Enum;

public class Main {

    public static void main(String[] args) {
        test();
    }
    public static void test() {

        // как нет конструктора у класса Car мы прописываем каждое поле отдельно (см пример 3)
        final Car taxi = new Car();
        taxi.cartype = CarType.TAXI;
        taxi.color = Color.RED;
        taxi.vin = "12345";
        taxi.number = "FBC1234";

        System.out.println(taxi);
    }
}
