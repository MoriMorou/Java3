import java.util.concurrent.*;

/**
 * Satyukova Alena
 * Java 3
 * Use 3 ExecutorService and print ABC 5 times
 */
public class App {

    public static void main(String[] args) throws Exception {

        Tasks tasks = new Tasks();
        ExecutorService es = Executors.newCachedThreadPool();

//        es.execute(new PrintA(tasks));
//        es.execute(new PrintB(tasks));
//        es.execute(new PrintC(tasks));
//        TimeUnit.SECONDS.sleep(5);
        es.shutdown();

        Print print = new Print();
        new Thread(() -> print.printing_a()).start();
        new Thread(() -> print.printing_b()).start();
        new Thread(() -> print.printing_c()).start();
    }
}






