package org.example.booleans;

import org.example.booleans.TrueFilter;
import org.example.Filter;
import org.junit.jupiter.api.Test;
import java.util.Collections;


import static org.junit.jupiter.api.Assertions.*;

public class TrueFilterTest {
    @Test
    public void testAlwaysTrue() {
        Filter f = new TrueFilter();
        assertTrue(f.matches(Collections.emptyMap()));
    }
    @Test
    void toStringReturnsTRUE() {
        Filter f = new TrueFilter();
        assertEquals("true", f.toString());
    }


}
