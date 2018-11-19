package ru.morimorou.java.Basis.Ex2_Enum;

import java.util.Date;

public class Car {

    String vin;
    String number;
    Integer countDoor;
    Date created;
    CarType cartype;
    Color color;
    Boolean damage;

    @Override
    public String toString() {
        return "Car{" +
                "vin='" + vin + '\'' +
                ", number='" + number + '\'' +
                ", countDoor=" + countDoor +
                ", created=" + created +
                ", cartype=" + cartype +
                ", color=" + color +
                ", damage=" + damage +
                '}';
    }
}
