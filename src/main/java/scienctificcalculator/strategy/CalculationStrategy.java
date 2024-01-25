package scienctificcalculator.strategy;

public sealed interface CalculationStrategy
        permits AverageStrategy, SinusStrategy, SubtractionStrategy, SummationStrategy {
    double execute(double... params);
}
