package demo1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterCountInStringTest {

    @ParameterizedTest
    @MethodSource
    void characterCountString(String input, String result) {
        assertEquals(result, CharacterCountInString.characterCountString(input));
    }

    static Stream<Arguments> characterCountString() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of("", ""),
                Arguments.of("AAA", "A3"),
                Arguments.of("XXXX", "X4"),
                Arguments.of("W", "W1"),
                Arguments.of("AABBCCZ", "A2B2C2Z1"),
                Arguments.of("DDDDA", "D4A1"),
                Arguments.of("ABXCV", "A1B1X1C1V1"),
                Arguments.of("DDDDAAABBX", "D4A3B2X1")
        );
    }
}