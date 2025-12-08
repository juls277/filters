package org.example.comparison;
import java.util.Map;
import org.example.Filter;
import org.example.visitor.FilterVisitor;

public class EqualsFilter implements Filter {
    private final String field;
    private final String value;
    public EqualsFilter(String field, String value) {
        this.field = field;
        this.value = value;

    }
    @Override
    public boolean matches(Map<String, String> resource) {
        String actual = resource.get(field);
        if (actual == null) {
            return false; // missing case
        }
        return actual.equalsIgnoreCase(value);
    }
    @Override
    public String toString() {
        return field + " == \"" + value + "\"";
    }
    @Override
    public <R> R accept(FilterVisitor<R> visitor) {
        return visitor.visit(this);
    }

}
