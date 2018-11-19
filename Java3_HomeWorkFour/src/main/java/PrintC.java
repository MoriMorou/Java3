import java.util.concurrent.TimeUnit;

public class PrintC implements Runnable {

    private Tasks tasks;

    public PrintC(Tasks c) {
        tasks = c;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                while (!Thread.interrupted()) {
                    tasks.printingC();
                    System.out.println("C!");
                    tasks.waitForPrintingAB();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done C");
    }
}
