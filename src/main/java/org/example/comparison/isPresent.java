package org.example.comparison;
import org.example.Filter;
import org.example.visitor.FilterVisitor;

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
    @Override
    public <R> R accept(FilterVisitor<R> visitor) {
        return visitor.visit(this);
    }

}
