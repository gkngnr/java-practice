package arrays;

import java.util.Arrays;

public class WorkerTwo {
    public static void main(String[] args) {
        final var sortedSquad = new SortedSquadArray(5000);

        final var insertArray = new long[]{4, 424, 24, 32, 43, 53, 256, 13, 33, 6456, 364236};

        Arrays.stream(insertArray).asDoubleStream().forEach(value ->
                {
                    System.out.println("Now inserting ->" + value);
                    sortedSquad.insert((long) value);
                    sortedSquad.display();
                });
        System.out.println();
        System.out.println("DELETION STARTED");

        final var deleteArray = new long[]{4, 4225, 234, 32, 431, 53};

        Arrays.stream(deleteArray).asDoubleStream().forEach(value ->
        {
            System.out.println("Now deleting -> " + value);
            System.out.println("Deleting result -> " + sortedSquad.delete((long) value));
            sortedSquad.display();
        });

    }
}
