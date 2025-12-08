package org.example.comparison;
import org.example.Filter;
import org.example.visitor.FilterVisitor;

import java.util.Map;
import java.util.regex.Pattern;

public class RegexFilter implements Filter {

    private final String property;
    private final Pattern pattern;

    public RegexFilter(String property, String regex) {
        this.property = property;
        this.pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    }

    @Override
    public boolean matches(Map<String, String> resource) {
        String actual = resource.get(property);
        if (actual == null) {
            return false;
        }
        return pattern.matcher(actual).matches();
    }
    @Override
    public String toString() {
        return property + " = /" + pattern + "/";
    }
    @Override
    public <R> R accept(FilterVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
