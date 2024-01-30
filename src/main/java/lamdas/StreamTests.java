package lamdas;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.Stream;

public class StreamTests {

    private static final Random randomInt = new Random();

    public static void main(String[] args) {

        getMaxOrMin(String::compareTo);
        getMaxOrMin(Comparator.reverseOrder());

        printAllIntegerMultiplied(Stream.of(1, 10, 100, 2));
    }

    static void infiniteStream() {
        Stream<Integer> integerStream = Stream.generate(() -> randomInt.nextInt(100)); //infinite
        integerStream.forEach(System.out::println);
    }

    static void filterStream() {
        Stream<String> stringStream = Stream.of("Ali", "Mehmet", "Celil", "Riza", "Zeyno");

        var result = stringStream.filter(s -> s.startsWith("Mex")).findAny();

        System.out.println(result.orElse("NONE"));
    }

    static void getMaxOrMin(Comparator<String> stringComparator) {
        Stream<String> stringStream = Stream.of("Ali", "Ahmet", "Celil", "Riza", "Zoey");

        final var result = stringStream.min(stringComparator);
        System.out.println(result.orElse("NONE"));
    }

    static void printAllIntegerMultiplied(Stream<Integer> intStream) {
        intStream.reduce((i1, i2) -> i1 * i2).ifPresent(System.out::println);
    }
}
