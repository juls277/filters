package org.example;

import java.util.Map;
import org.example.visitor.FilterVisitor;

public interface Filter {
    boolean matches(Map<String, String> resource);
    <R> R accept(FilterVisitor<R> visitor);
}