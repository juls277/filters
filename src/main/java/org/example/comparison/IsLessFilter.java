package org.example.comparison;
import org.example.Filter;
import java.util.Map;

public class IsLessFilter implements Filter {

    private final String key;
    private final String value;

    public IsLessFilter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean matches(Map<String, String> resource) {
        String actual = resource.get(key);
        if (actual == null) {
            return false;
        }

        try {
            double actualNum = Double.parseDouble(actual);
            double thresholdNum = Double.parseDouble(value);
            return actualNum < thresholdNum;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    @Override
    public String toString() {
        return key + " < " + value;
    }
}