package scienctificcalculator.strategy;

import java.util.Arrays;

public final class AverageStrategy implements CalculationStrategy {
    @Override
    public double execute(double... params) {
        return Arrays.stream(params).average().orElseThrow();
    }
}
