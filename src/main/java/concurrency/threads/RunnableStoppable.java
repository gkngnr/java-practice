package concurrency.threads;

public class RunnableStoppable implements Runnable {
    private boolean stopRequested;

    public synchronized void requestStop() {
        this.stopRequested = true;
    }

    public synchronized boolean isStopRequested() {
        return this.stopRequested;
    }
    @Override
    public void run() {
        final var tName = Thread.currentThread().getName();
        System.out.println(tName + " is started");
        while (!isStopRequested()) {
            System.out.println("...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(tName + " is stopping");
    }

    public static void main(String[] args) throws InterruptedException {
        RunnableStoppable r1 = new RunnableStoppable();
        Thread t1 = new Thread(r1, "T1");
        t1.start();
        Thread.sleep(6000);
        r1.requestStop();

    }
}
