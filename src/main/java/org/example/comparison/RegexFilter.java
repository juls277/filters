package org.example.comparison;

import org.example.Filter;

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
}
