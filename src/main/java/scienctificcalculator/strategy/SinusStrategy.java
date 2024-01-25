package scienctificcalculator.strategy;

public final class SinusStrategy implements CalculationStrategy {
    @Override
    public double execute(double... params) {
        if (params.length != 1) {
            throw new IllegalArgumentException("number of param for sinus must be one");
        }
        return Math.sin(params[0]);
    }
}
