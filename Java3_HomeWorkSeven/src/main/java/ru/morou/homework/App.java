package ru.morou.homework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

import static java.util.Comparator.comparingInt;

/**
 * Satyukova Alena
 *
 */
public class App {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        start(Test1.class);
        System.out.println("\n");
        start(Test2.class);
        System.out.println("\n");
    }

    public static void start(Class c) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Method[] methods = c.getDeclaredMethods();
        int bsCount = 0, asCount = 0;
        List<Method> tests = new ArrayList<>();
        // check on uniqueness for BEFORE & AFTER SUITES. Adding TESTS to ArrayList
        for (Method o : methods) {
            String type = o.getDeclaredAnnotations()[0].annotationType().getSimpleName();
            if (type.equals("BeforeSuite")) {
                bsCount++;
                if (bsCount > 1) throw new RuntimeException("You can use only 1 before annotation.");
            } else if (type.equals("AfterSuite")) {
                asCount++;
                if (asCount > 1) throw new RuntimeException("You can use only 1 after annotation.");
            } else if (type.equals("Test")) {
                tests.add(o);
            }
        }

        // Sort TESTS list by VALUE
        tests.sort(comparingInt(new ToIntFunction<Method>() {
            @Override
            public int applyAsInt(Method o2) {
                return o2.getAnnotation(Test.class).priority();
            }
        }));

        // Add BEFORE SUITE to begin of TESTS & AFTER SUITE to the end.
        for (Method o : methods) {
            String type = o.getDeclaredAnnotations()[0].annotationType().getSimpleName();
            if (type.equals("BeforeSuite")) {
                tests.add(0, o);
            }
            if (type.equals("AfterSuite")) {
                tests.add(o);
            }
        }

        // Show info. Run TESTS
        for (Method i : tests) {
            try {
                System.out.print("(" + i.getDeclaredAnnotation(Test.class).priority() + ") ");
            } catch (NullPointerException e) {
            }
            i.invoke(c.newInstance(),  null);
        }
    }
}
