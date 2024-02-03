package concurrency.api;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class SingleExecutor {

    private static Runnable longTask = () -> IntStream.range(0, 1000_000).filter(i -> i % 20000 == 0).forEach(System.out::println);
    private static Runnable shortTask = () -> System.out.println("Just a simple task");

    public static void main(String[] args) {
        try (ExecutorService singleExecutor = Executors.newSingleThreadExecutor()) {
            submit(singleExecutor);
        }

    }

    static void submit(ExecutorService executorService) {
        Future<?> result1 = executorService.submit(shortTask);
        Future<?> result2 = executorService.submit(longTask);
        Future<?> result3 = executorService.submit(shortTask);

        try {
            result2.get(2, TimeUnit.NANOSECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            System.out.println("Not Finished"); // 2 nanosecond is short enough for the result2 to be finished.
        }
    }

    //calling execute returns nothing, prefer submit to have Callable enables checking on thread status etc
    static void execute(ExecutorService executorService) {
        executorService.execute(shortTask);
        executorService.execute(longTask);
        executorService.execute(shortTask);
    }
}
