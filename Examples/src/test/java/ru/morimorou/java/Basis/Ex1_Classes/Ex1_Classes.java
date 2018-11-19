package ru.morimorou.java.Basis.Ex1_Classes;

import static org.junit.Assert.assertTrue;

/**
 * Классы и методы
 */
public class Ex1_Classes {
    /**
     * классы содержат только поля и методы
     */

    public static void main( String[] args ) {
        String car = "Mers";
        going(car);


    }
    private static void going (String car) {
        System.out.println(car + " ia going");
    }
}
