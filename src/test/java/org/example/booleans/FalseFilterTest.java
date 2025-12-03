package org.example.booleans;
import org.example.Filter;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
public class FalseFilterTest {
    @Test
    void testAlwaysFalse() {
        Filter f = new FalseFilter();
        assertFalse(f.matches(Collections.emptyMap()));
    }
}