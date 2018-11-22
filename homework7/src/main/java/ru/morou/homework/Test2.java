package ru.morou.homework;

public class Test2 {

    @AfterSuite
    public static void taskAfter(){
        System.out.println(Test2.class.getSimpleName() + " after");
    }
//
//
//    @Test
//    public static void task1() {
//        System.out.println(Test2.class.getSimpleName() + " task1");
//    }
//
//    @Test(3)
//    public static void task2() {
//        System.out.println(Test2.class.getSimpleName() + " task2");
//    }
}
