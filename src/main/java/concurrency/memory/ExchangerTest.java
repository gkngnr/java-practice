package concurrency.memory;

import java.util.stream.IntStream;

public class ExchangerTest {

    public static void main(String[] args) {
        var exchanger = new Exchanger();
        Runnable r1 = () -> {
            IntStream.range(0, 100_000).forEach(value -> exchanger.inc());
            System.out.println(Thread.currentThread().getName() + ":" + exchanger.getCounter().get());
        };

        Thread t1 = new Thread(r1, "T1");
        Thread t2 = new Thread(r1, "T2");

        t1.start();
        t2.start();
    }

}
