package demo1;

import java.util.HashMap;
import java.util.Map;

public class CurrencyProblem {
    static  Map<String, Map<String, Double>> currencies = new HashMap<>();
    static Map<String, Double> dollars = new HashMap<>();

    static {
        dollars.put("EUR", 1.12);
        dollars.put("AUD", 1.55);
        dollars.put("TRY", 18.12);
        dollars.put("CAD", 1.52);
        currencies.put("USD", dollars);
    }

    public static void main(String[] args) {
        System.out.println(getRate("USD", "EUR"));
        System.out.println(getRate("USD", "TRY"));
        System.out.println(getRate("CAD", "USD"));
    }

    public static Double getRate(String currency1, String currency2) {
        if (currencies.containsKey(currency1)) {
            return getRateWithDivisionOrder(currency1, currency2);
        }
        if (currencies.containsKey(currency2)) {
            return 1 / getRateWithDivisionOrder(currency2, currency1);
        }
        return -1.0;

    }

    public static Double getRateWithDivisionOrder(String parentCurrency, String childCurrency) {
        var currencyNodeMap = currencies.get(parentCurrency);
        if (currencyNodeMap.containsKey(childCurrency)) {
            return currencyNodeMap.get(childCurrency);
        }
        return -1.0;
    }
}
