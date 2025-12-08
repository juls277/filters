package org.example.logical;
import org.example.Filter;
import java.util.Map;
public class AndFilter implements Filter {
    private final Filter left;
    private final Filter right;

    public AndFilter(Filter left, Filter right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public boolean matches (Map<String, String> resource) {
        return left.matches(resource) && right.matches(resource);
    }
    @Override
    public String toString() {
        return "(" + left.toString() + " AND " + right.toString() + ")";
    }

}

