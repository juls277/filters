package org.example.logical;
import org.example.Filter;
import org.example.booleans.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class OrFilterTest {
    @Test
    //true || true
    void trueOrTrueIsTrue() {
        Filter f = new OrFilter(new TrueFilter(), new TrueFilter());
        assertTrue(f.matches(Collections.emptyMap()));
    }

    @Test
        //true || false
    void trueOrFalseIsFalse() {
        Filter f = new OrFilter(new TrueFilter(), new FalseFilter());
        assertTrue(f.matches(Collections.emptyMap()));
    }

    @Test
        //false || false
    void falseOrFalseIsFalse() {
        Filter f = new OrFilter(new FalseFilter(), new FalseFilter());
        assertFalse(f.matches(Collections.emptyMap()));
    }

    @Test
    void toStringShowsOrExpression() {
        Filter f = new OrFilter(new TrueFilter(), new FalseFilter());
        assertEquals("(true OR false)", f.toString());
    }

}
