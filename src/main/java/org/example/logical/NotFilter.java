package org.example.logical;
import org.example.Filter;
import java.util.Map;
import org.example.visitor.FilterVisitor;

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
    @Override
    public <R> R accept(FilterVisitor<R> visitor) {
        return visitor.visit(this);
    }

    public Filter getProperty() {return property;}
}