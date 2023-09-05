package recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    @ParameterizedTest
    @MethodSource
    void search(int searchedVal, int result) {
        final int[] testedArray = {3, 5, 7, 8, 12, 34, 53, 64, 78, 91, 313, 423, 734, 982, 3134, 4094, 8918, 82744, 731928};
        assertEquals(result, BinarySearch.search(testedArray, searchedVal));
    }

    private static Stream<Arguments> search() {
        return Stream.of(
                Arguments.of(3, 0),
                Arguments.of(5, 1),
                Arguments.of(7, 2),
                Arguments.of(8, 3),
                Arguments.of(12, 4),
                Arguments.of(34, 5),
                Arguments.of(53, 6),
                Arguments.of(64, 7),
                Arguments.of(78, 8),
                Arguments.of(91, 9),
                Arguments.of(313, 10),
                Arguments.of(423, 11),
                Arguments.of(734, 12),
                Arguments.of(982, 13),
                Arguments.of(3134, 14),
                Arguments.of(4094, 15),
                Arguments.of(8918, 16),
                Arguments.of(82744, 17),
                Arguments.of(731928, 18),
                Arguments.of(43802934, -1),
                Arguments.of(1, -1),
                Arguments.of(10, -1),
                Arguments.of(40, -1),
                Arguments.of(80, -1),
                Arguments.of(500, -1),
                Arguments.of(1000, -1),
                Arguments.of(9000, -1),
                Arguments.of(90000, -1),
                Arguments.of(900000, -1)
        );
    }
}