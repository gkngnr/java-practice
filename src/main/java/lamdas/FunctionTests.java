package lamdas;

import java.util.function.Function;

public class FunctionTests {

    public static void main(String[] args) {
        Function<Float, Integer> removePrecision = Float::intValue;

        System.out.println(removePrecision.apply(12.34F));

    }
}

