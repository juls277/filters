package org.example;
import java.util.Map;

public abstract class AbstractNumericComparisonFilter implements Filter {

    protected final String key;
    protected final String value;

    public AbstractNumericComparisonFilter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    //subclass defines its own comparison operator
    protected abstract boolean compare(double actual, double threshold);

    //subclass defines its own tostring operator
    protected abstract String operatorSymbol();

    @Override
    public boolean matches(Map<String, String> resource) {
        String actual = resource.get(key);
        if (actual == null) {
            return false;
        }

        try {
            double actualNum = Double.parseDouble(actual);
            double thresholdNum = Double.parseDouble(value);
            return compare(actualNum, thresholdNum);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return key + " " + operatorSymbol() + " " + value;
    }
}
