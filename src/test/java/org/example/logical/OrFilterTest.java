package org.example.logical;
import org.example.Filter;
import org.example.booleans.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class OrFilterTest {
    @Test
    //true || true
    void trueAndTrueIsTrue() {
        Filter f = new AndFilter(new TrueFilter(), new TrueFilter());
        assertTrue(f.matches(Collections.emptyMap()));
    }

    @Test
        //true || false
    void trueAndFalseIsFalse() {
        Filter f = new AndFilter(new TrueFilter(), new FalseFilter());
        assertTrue(f.matches(Collections.emptyMap()));
    }

    @Test
        //false || false
    void falseAndFalseIsFalse() {
        Filter f = new AndFilter(new FalseFilter(), new FalseFilter());
        assertFalse(f.matches(Collections.emptyMap()));
    }
}
