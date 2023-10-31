package concurrency.memory;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Exchanger {
    private AtomicInteger counter = new AtomicInteger(0);

    public void inc() {
        counter.getAndIncrement();
    }

}
