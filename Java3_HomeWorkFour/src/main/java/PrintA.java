import java.util.concurrent.TimeUnit;

class PrintA implements Runnable {

    private Tasks tasks;

    public PrintA(Tasks t) {
        tasks = t;
    }

    public void run() {
        for (int i = 0; i < 5; i++){
            try {
                while (!Thread.interrupted()) {
                    tasks.printingA();
                    System.out.println("A!");
                    tasks.waitForPrintingBC();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done A");
    }
}
