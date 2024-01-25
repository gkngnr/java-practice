package scienctificcalculator.strategy;

import java.util.Arrays;

public final class SummationStrategy implements CalculationStrategy {
    @Override
    public double execute(double... params) {
        return Arrays.stream(params).sum();
    }
}
