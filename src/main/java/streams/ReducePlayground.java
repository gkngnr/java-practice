package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReducePlayground {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("G", "O", "K", "H", "A", "N");

        System.out.println(mergeStreamOfStringToReverseSortedTree(stringStream));
    }

    public static int calculateLengthOfAllStrings(Stream<String> stringStream) {
        return stringStream.reduce(0, (i, s) -> i + s.length(), Integer::sum);
    }

    public static String mergeStreamOfStringWithStringBuilder(Stream<String> stringStream) {
        return stringStream.collect(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append
        ).toString();
    }

    public static Set<String> mergeStreamOfStringToTreeSet(Stream<String> stringStream) {
        return stringStream.collect(
                TreeSet::new,
                TreeSet::add,
                TreeSet::addAll
        );
    }

    public static Set<String> mergeStreamOfStringToTreeSetEasyWay(Stream<String> stringStream) {
        return stringStream.collect(Collectors.toCollection(TreeSet::new));
    }

    public static Set<String> mergeStreamOfStringToTree(Stream<String> stringStream) {
        return stringStream.collect(Collectors.toSet());
    }

    public static Set<String> mergeStreamOfStringToReverseSortedTree(Stream<String> stringStream) {
        return stringStream.collect(
                Collectors.toCollection(() -> new TreeSet<>((o1, o2) -> o2.compareTo(o1)))
        );
    }

    public static List<String> mergeStreamOfStringToLinkedList(Stream<String> stringStream) {
        return stringStream.collect(Collectors.toCollection(LinkedList::new));
    }

}
