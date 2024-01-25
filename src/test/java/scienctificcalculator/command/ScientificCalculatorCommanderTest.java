package scienctificcalculator.command;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import scienctificcalculator.enums.CalculationType;

import static org.junit.jupiter.api.Assertions.*;

class ScientificCalculatorCommanderTest {

    @Test
    void command() {
        final var commander = new ScientificCalculatorCommander(CalculationType.AVERAGE);
        assertEquals(15.0, commander.command(10.0, 15.0, 20.0));
    }
}