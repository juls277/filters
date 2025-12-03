package org.example;

import java.util.Map;

public interface Filter {
    boolean matches(Map<String, String> resource);
}