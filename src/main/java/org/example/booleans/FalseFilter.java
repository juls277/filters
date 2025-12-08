package org.example.booleans;
import org.example.Filter;
import org.example.visitor.FilterVisitor;
import java.util.Map;
public class FalseFilter implements Filter {
    @Override
    public boolean matches(Map<String, String> resource) {
        return false;
    }
    @Override
    public String toString() {
        return "false";
    }

    @Override
    public <R> R accept(FilterVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
