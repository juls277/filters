package org.example.booleans;
import org.example.Filter;
import java.util.Map;
import org.example.visitor.FilterVisitor;
public class TrueFilter implements Filter {
    @Override
    public boolean matches(Map<String, String> resource) {
        return true;
    }
    @Override
    public String toString() {
        return "true";
    }
    @Override
    public <R> R accept(FilterVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
