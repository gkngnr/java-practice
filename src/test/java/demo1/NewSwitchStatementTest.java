package demo1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NewSwitchStatementTest {

    @ParameterizedTest
    @MethodSource("generateInputAndReturnValues")
    void getQuarterName_shouldReturnCorrectQName(Integer input, String expected) {
        Assertions.assertEquals(expected, NewSwitchStatement.getQuarterName(input));
    }

    private static Stream<Arguments> generateInputAndReturnValues() {
        return Stream.of(
                Arguments.of(1, "Q1"),
                Arguments.of(2, "Q1"),
                Arguments.of(3, "Q1"),
                Arguments.of(4, "Q2"),
                Arguments.of(5, "Q2"),
                Arguments.of(6, "Q2"),
                Arguments.of(7, "Q3"),
                Arguments.of(8, "Q3"),
                Arguments.of(9, "Q3"),
                Arguments.of(10, "Q4"),
                Arguments.of(11, "Q4"),
                Arguments.of(12, "Q4"),
                Arguments.of(122, "Wrong month no passed")
        );
    }

}