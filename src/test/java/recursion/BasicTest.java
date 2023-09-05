package recursion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BasicTest {

    @Test
    void triangle() {
        assertThat(Basic.triangle(1000)).isEqualTo(500500);
    }

    @Test
    void factorial() {
        assertThat(Basic.factorial(5)).isEqualTo(120);
    }

    @ParameterizedTest
    @CsvSource({"DAR,RAD", "READ,DAER", "KAYAK,KAYAK", "TENANT, TNANET"})
    void reverse(String input, String expected) {
        assertThat(Basic.reverse(input)).isEqualTo(expected);
    }

    @Test
    void isPalindrome() {
        assertThat(Basic.isPalindrome("KAYAK")).isTrue();
        assertThat(Basic.isPalindrome("T")).isTrue();
        assertThat(Basic.isPalindrome("RACECAR")).isTrue();
        assertThat(Basic.isPalindrome("READ")).isFalse();
    }
}