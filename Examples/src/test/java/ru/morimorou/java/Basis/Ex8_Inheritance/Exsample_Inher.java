package ru.morimorou.java.Basis.Ex8_Inheritance;

import org.junit.Test;

public class Exsample_Inher {

    private interface IGroundTransport{
    }

    private interface IAirTransport{
    }

    private abstract class Transport {
    }

    private class Car extends Transport implements IGroundTransport{
    }

    private class CargoCar extends Car{
    }

    @Test
    public void Test(){
        Car car = new Car();
        assert(car instanceof Transport);
    }
}
