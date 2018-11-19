public class Tasks {

    private boolean prA = false;
    private boolean prB = false;
    private boolean prC = false;

    public synchronized void printingA() {
        prA = true;
        prB = false;
        prC = false;
        notifyAll();
    }

    public synchronized void printingB() {
        prA = false;
        prB = true;
        prC = false;
        notifyAll();
    }

    public synchronized void printingC() {
        prA = false;
        prB = false;
        prC = true;
        notifyAll();
    }


    public synchronized void waitForPrintingBC() throws InterruptedException {
        while (!prB && !prC) wait();

    }

    public synchronized void waitForPrintingAC() throws InterruptedException {
        while (!prA && !prC) wait();

    }

    public synchronized void waitForPrintingAB() throws InterruptedException {
        while (!prA && !prB) wait();
    }


}
