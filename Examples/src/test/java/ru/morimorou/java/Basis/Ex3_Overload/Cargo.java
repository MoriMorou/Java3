package ru.morimorou.java.Basis.Ex3_Overload;

import java.util.Date;

public class Cargo {

    String vin;
    Date created;

    public Cargo(Date created) {
        this.created = created;
    }

    public Cargo() {
    }

    public Cargo(String vin) {
        this.vin = vin;
    }

    public Cargo(String vin, Date created) {
        this.vin = vin;
        this.created = created;
    }

    // конструкторы, которые выше позволяют проводить иницализацию объектов без
    // рассписываня каждого значения в отдельном поле см пример 2
    public static void main(String[] args) {
        System.out.println(new Cargo());
        System.out.println(new Cargo("34567"));
        System.out.println(new Cargo("34567", new Date()));
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "vin='" + vin + '\'' +
                ", created=" + created +
                '}';
    }
}
