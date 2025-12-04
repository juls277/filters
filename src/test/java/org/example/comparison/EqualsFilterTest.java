package org.example.comparison;
import org.example.Filter;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class EqualsFilterTest {

    @Test
    void matchesWhenValueEqualIgnorCase() {
        Map<String, String> map = new HashMap<>();
        map.put("field", "VALUE");

        Filter f = new EqualsFilter("field", "value");
        assertTrue(f.matches(map));
    }

    @Test
    void doesNotMatchWhenValueDifferent() {
        Map<String, String> map = new HashMap<>();
        map.put("field", "abc");

        Filter f = new EqualsFilter("field", "xyz");
        assertFalse(f.matches(map));
    }

    @Test
    void doesNotMatchWhenFieldMissing() {
        Map<String, String> map = new HashMap<>();

        Filter f = new EqualsFilter("field", "value");
        assertFalse(f.matches(map));
    }
}

