import java.util.concurrent.TimeUnit;

public class PrintB implements Runnable {

    private Tasks tasks;

    public PrintB(Tasks c) {
        tasks = c;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {

                while (!Thread.interrupted()) {
                    tasks.printingB();
                    System.out.println("B!");
                    tasks.waitForPrintingAC();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done B");
    }
}
