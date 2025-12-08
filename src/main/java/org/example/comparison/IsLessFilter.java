package org.example.comparison;
import org.example.AbstractNumericComparisonFilter;

public class IsLessFilter extends AbstractNumericComparisonFilter {

    public IsLessFilter(String key, String value) {
        super(key, value);
    }

    @Override
    protected boolean compare(double actual, double threshold) {
        return actual < threshold;
    }

    @Override
    protected String operatorSymbol() {
        return "<";
    }
}
