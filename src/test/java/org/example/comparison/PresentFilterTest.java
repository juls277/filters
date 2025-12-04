package org.example.comparison;
import org.example.Filter;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class IsPresentTest {

    @Test
    void matchesWhenPropertyExists() {
        Map<String, String> map = new HashMap<>();
        map.put("field", "value");

        Filter f = new isPresent("field");
        assertTrue(f.matches(map));
    }

    @Test
    void doesNotMatchWhenPropertyMissing() {
        Map<String, String> map = new HashMap<>();
        map.put("other", "value");

        Filter f = new isPresent("field");
        assertFalse(f.matches(map));
    }

    @Test
    void doesNotMatchOnEmptyMap() {
        Map<String, String> map = new HashMap<>();

        Filter f = new isPresent("field");
        assertFalse(f.matches(map));
    }
}
