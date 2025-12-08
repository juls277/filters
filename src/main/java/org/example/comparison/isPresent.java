package org.example.comparison;
import org.example.Filter;
import java.util.Map;

public class isPresent implements Filter {
    private final String propertyName;

    public isPresent(String propertyName) {
        this.propertyName = propertyName;
    }

    @Override
    public boolean matches(Map<String, String> resource) {
        return resource.containsKey(propertyName);
    }
    @Override
    public String toString() {
        return "HAS(" + propertyName + ")";
    }
}
