package scienctificcalculator.strategy;

import java.math.BigDecimal;

public final class SubtractionStrategy implements CalculationStrategy {
    @Override
    public double execute(double... params) {
        if (params.length != 2) {
            throw  new IllegalArgumentException("number of param for subtraction should be two");
        }
        final var p1 = BigDecimal.valueOf(params[0]);
        final var p2 = BigDecimal.valueOf(params[1]);

        return p1.subtract(p2).doubleValue();

    }
}
