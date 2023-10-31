package concurrency.memory;

import java.util.stream.IntStream;

public class BasicRunnable implements Runnable {
    private int count = 0;
    @Override
    public void run() {
        synchronized (this) {
            IntStream.range(0, 100_000).forEach(value -> this.count++);
        }
        System.out.println(Thread.currentThread().getName() + ":" + this.count);

    }
}
