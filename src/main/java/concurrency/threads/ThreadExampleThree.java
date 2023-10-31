package concurrency.threads;

public class ThreadExampleThree {

    public static void main(String[] args) {
        Runnable r1 = () -> {
            final var threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is started");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(threadName + " is finished");

        };

        Thread t1 = new Thread(r1, "T1");
        Thread t2 = new Thread(r1, "T2");

        t1.start();
        t2.start();
    }
}
