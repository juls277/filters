package org.example.logical;
import org.example.Filter;
import org.example.visitor.FilterVisitor;

import java.util.Map;
public class OrFilter implements Filter{
    private final Filter left;
    private final Filter right;

    public OrFilter(Filter left, Filter right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public boolean matches (Map<String, String> resource) {
        return left.matches(resource) || right.matches(resource);
    }
    @Override
    public String toString() {
        return "(" + left.toString() + " OR " + right.toString() + ")";
    }
    @Override
    public <R> R accept(FilterVisitor<R> visitor) {
        return visitor.visit(this);
    }

    public Filter getLeft() {return left;}
    public Filter getRight() {return right;}
}
