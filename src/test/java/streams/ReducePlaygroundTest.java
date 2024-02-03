package streams;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ReducePlaygroundTest {



    static Stream<Arguments> calculateLengthOfAllStrings() {
        return Stream.of(
                Arguments.of(Stream.of(""), 0),
                Arguments.of(Stream.empty(), 0),
                Arguments.of(Stream.of("A"), 1),
                Arguments.of(Stream.of("AS"), 2),
                Arguments.of(Stream.of("a3", "w"), 3),
                Arguments.of(Stream.of("a3", "w"), 3),
                Arguments.of(Stream.of("s", "t", "er!"), 5),
                Arguments.of(Stream.of("s34", "t3a", "er!"), 9)
        );

    }

    @ParameterizedTest
    @MethodSource
    void calculateLengthOfAllStrings(Stream<String> stringStream, Integer result) {
        assertEquals(result, ReducePlayground.calculateLengthOfAllStrings(stringStream));
    }
}