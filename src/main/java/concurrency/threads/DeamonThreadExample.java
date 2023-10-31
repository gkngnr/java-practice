package concurrency.threads;

import java.util.stream.IntStream;

public class DeamonThreadExample {

    public static void main(String[] args) {
        Runnable r1 = () -> IntStream.range(0, 10).forEach(value -> {
                        sleep(1000);
                        System.out.println("Running");
                    }
                );
        Thread t1 = new Thread(r1, "T1");
        t1.setDaemon(true);
        t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void sleep(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
