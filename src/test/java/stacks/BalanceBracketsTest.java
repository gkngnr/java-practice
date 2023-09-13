package stacks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BalanceBracketsTest {


    @ParameterizedTest
    @MethodSource
    void isBalanced(String input, boolean result) {
        assertEquals(result, BalanceBrackets.isBalanced(input));
    }

    static Stream<Arguments> isBalanced() {
        return Stream.of(
                Arguments.of("dlkajdsla", true),
                Arguments.of("", true),
                Arguments.of("4rt{dsfsdf}432", true),
                Arguments.of("da{sfr[dadad]dsa}das(trert)", true),
                Arguments.of("fjfsaf(dad)dfs(dsed", false),
                Arguments.of("342((())]rw", false),
                Arguments.of("{{{)}}}", false),
                Arguments.of("(((()))[]))", false)
        );
    }
}