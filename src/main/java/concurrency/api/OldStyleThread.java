package concurrency.api;

import java.util.stream.IntStream;

public class OldStyleThread {
    private static int counter = 0;

    public static void main(String[] args) {
        final var mainThread = Thread.currentThread();
        new Thread(() -> {
            IntStream.range(0, 100_000).forEach(i -> counter++);
            mainThread.interrupt(); // interrupt the main thread to shorted its sleep
        }).start();

        while (counter < 100_000) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
            System.out.println("Not reached the limit");
        }

        System.out.println("END OF LINE");
        System.out.println(counter);

    }

    static void callMultiple() {
        Runnable printItem = () -> System.out.println("Printing only item");
        Runnable printMutliItem = () -> IntStream.range(0, 5).forEach(i -> System.out.println("Printing " + i));
        System.out.println("STARTED!");
        new Thread(printItem).start();
        new Thread(printMutliItem).start();
        new Thread(printItem).start();

        System.out.println("ENDED!");
    }
}
