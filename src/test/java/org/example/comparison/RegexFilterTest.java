package org.example.comparison;
import org.example.Filter;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RegexFilterTest {

    @Test
    void matchesWhenValueMatchesRegex() {
        Map<String, String> map = new HashMap<>();
        map.put("email", "user@example.com");

        Filter f = new RegexFilter("email", ".*@example\\.com");
        assertTrue(f.matches(map));
    }

    @Test
    void matchesIgnoringCase() {
        Map<String, String> map = new HashMap<>();
        map.put("code", "abc123");

        Filter f = new RegexFilter("code", "[A-Z]{3}123");
        assertTrue(f.matches(map));
    }

    @Test
    void doesNotMatchWhenValueDoesNotMatch() {
        Map<String, String> map = new HashMap<>();
        map.put("email", "user@other.com");

        Filter f = new RegexFilter("email", ".*@example\\.com");
        assertFalse(f.matches(map));
    }

    @Test
    void doesNotMatchWhenPropertyMissing() {
        Map<String, String> map = new HashMap<>();

        Filter f = new RegexFilter("email", ".*@example\\.com");
        assertFalse(f.matches(map));
    }
}
