package org.example.comparison;
import org.example.Filter;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class IsLessFilterTest {

    @Test
    void matchesWhenActualIsLess() {
        Map<String, String> map = new HashMap<>();
        map.put("age", "20");

        Filter f = new IsLessFilter("age", "30");
        assertTrue(f.matches(map));
    }

    @Test
    void doesNotMatchWhenEqual() {
        Map<String, String> map = new HashMap<>();
        map.put("age", "30");

        Filter f = new IsLessFilter("age", "30");
        assertFalse(f.matches(map));
    }

    @Test
    void doesNotMatchWhenActualIsGreater() {
        Map<String, String> map = new HashMap<>();
        map.put("age", "40");

        Filter f = new IsLessFilter("age", "30");
        assertFalse(f.matches(map));
    }

    @Test
    void doesNotMatchWhenPropertyMissing() {
        Map<String, String> map = new HashMap<>();

        Filter f = new IsLessFilter("age", "30");
        assertFalse(f.matches(map));
    }

    @Test
    void doesNotMatchWhenValueIsNotNumber() {
        Map<String, String> map = new HashMap<>();
        map.put("age", "abc");

        Filter f = new IsLessFilter("age", "30");
        assertFalse(f.matches(map));
    }
}
