package ru.morou.homework;

/**
 * HomeWork 6
 * Alena Satyukova
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Array array = new Array();
        int[] arrOne = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        array.arrayCheck(arrOne);
        System.out.println(array.booleanCheck(arrOne));
    }
}
