package scienctificcalculator.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import scienctificcalculator.enums.CalculationType;
import scienctificcalculator.strategy.*;

@NoArgsConstructor(access = AccessLevel.NONE)
public class CalculatorStrategyFactory {
    public static CalculationStrategy generate(CalculationType calculationType) {
        return switch (calculationType) {
            case SINUS -> new SinusStrategy();
            case AVERAGE -> new AverageStrategy();
            case SUBTRACTION -> new SubtractionStrategy();
            case SUMMATION -> new SummationStrategy();
        };
    }
}
