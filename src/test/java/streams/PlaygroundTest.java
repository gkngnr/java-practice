package streams;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlaygroundTest {

    @ParameterizedTest
    @MethodSource
    void calculateSum(int result, List<Integer> nums) {
        assertEquals(result, Playground.calculateSum(nums));
    }

    private static Stream<Arguments> calculateSum() {
        return Stream.of(
                Arguments.of(0, List.of(1, 3, 5, 7)),
                Arguments.of(2, List.of(0, 1, 2, 3)),
                Arguments.of(20, List.of(2, 4, 6, 8)),
                Arguments.of(100, List.of(1, 30, 5, 70))
        );
    }

    @ParameterizedTest
    @MethodSource
    void isPalindrome(Boolean result, String input) {
        assertEquals(result, Playground.isPalindrome(input));
    }

    private static Stream<Arguments> isPalindrome() {
        return Stream.of(
                Arguments.of(false, "tre"),
                Arguments.of(false, "trex"),
                Arguments.of(false, "treerrt"),
                Arguments.of(false, "babba"),
                Arguments.of(true, "abba"),
                Arguments.of(true, "abxba"),
                Arguments.of(true, "hannah")
        );
    }

    @ParameterizedTest
    @MethodSource
    void getMaxOfOdds(Integer result, List<Integer> nums) {
        assertEquals(result, Playground.getMaxOfOdd(nums));
    }

    private static Stream<Arguments> getMaxOfOdds() {
        return Stream.of(
                Arguments.of(5, List.of(1, 3, 5, 66, 70, 4, 8)),
                Arguments.of(111, List.of(111, 23, 52, 66, 70, 44, 48)),
                Arguments.of(-1, List.of(4, 6, 1414, 90090)),
                Arguments.of(31515, List.of(4, 6, 1414, 90090, 31515))
        );
    }


}