package scienctificcalculator.command;

import lombok.RequiredArgsConstructor;
import scienctificcalculator.enums.CalculationType;
import scienctificcalculator.factory.CalculatorStrategyFactory;

@RequiredArgsConstructor
public final class ScientificCalculatorCommander implements CalculatorCommander {

    private final CalculationType calculationType;
    @Override
    public double command(double... params) {
        return CalculatorStrategyFactory.generate(calculationType).execute(params);
    }
}
