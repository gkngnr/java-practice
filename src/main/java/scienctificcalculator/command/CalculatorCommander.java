package scienctificcalculator.command;

import scienctificcalculator.enums.CalculationType;
import scienctificcalculator.strategy.CalculationStrategy;

public sealed interface CalculatorCommander permits ScientificCalculatorCommander {
    double command(double... params);
}
