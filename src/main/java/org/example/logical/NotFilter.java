package org.example.logical;
import org.example.Filter;
import java.util.Map;

public class NotFilter implements Filter {

    private final Filter property;

    public NotFilter(Filter property) {
        this.property = property;
    }

    @Override
    public boolean matches(Map<String, String> resource) {

        return !property.matches(resource);
    }
    @Override
    public String toString() {
        return "(NOT " + property.toString() + ")";
    }
}