package ru.morou.homework;

public class Test1 {

    @BeforeSuite
    public static void taskBefore() {
        System.out.println(Test1.class.getSimpleName() + " before");
    }

    @Test(value = 10)
    public void task1() {
        System.out.println(Test1.class.getSimpleName() + " task1");
    }
//
//    @Test(value = 3)
//    public static void task2() {
//        System.out.println(Test1.class.getSimpleName() + " task2");
//    }
//
//    @Test(value = 4)
//    public static void task3() {
//        System.out.println(Test1.class.getSimpleName() + " task3");
//    }
//
//    @Test(value = 3)
//    public static void task4() {
//        System.out.println(Test1.class.getSimpleName() + " task3");
//    }

    @AfterSuite
    public static void taskAfter() {
        System.out.println(Test1.class.getSimpleName() + " after");
    }
}
