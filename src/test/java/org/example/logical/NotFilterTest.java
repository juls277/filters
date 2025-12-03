package org.example.logical;

import org.example.Filter;
import org.example.booleans.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class NotFilterTest {

    @Test
    void notTrueIsFalse() {
        Filter f = new NotFilter(new TrueFilter());
        assertFalse(f.matches(Collections.emptyMap()));
    }

    @Test
    void notFalseIsTrue() {
        Filter f = new NotFilter(new FalseFilter());
        assertTrue(f.matches(Collections.emptyMap()));
    }
}