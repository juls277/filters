package org.example.integration;
import org.example.Filter;
import org.example.comparison.*;
import org.example.logical.*;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
public class ComplexFilterTreeTest {
    @Test
    void complexTreeMatchesCorrectUser() {

        // (role == "administrator" AND age > 30)
        Filter adminOlderThan30 = new AndFilter(
                new EqualsFilter("role", "administrator"),
                new isGreaterFilter("age", "30")
        );

        // (HAS(email) AND NOT(email =~ /.*@spam\.com/))
        Filter validEmail = new AndFilter(
                new isPresent("email"),
                new NotFilter(new RegexFilter("email", ".*@spam\\.com"))
        );

        // FULL TREE:
        Filter complex = new OrFilter(adminOlderThan30, validEmail);

        Map<String, String> user = new java.util.HashMap<>();

        user.put("email", "joe@example.com");
        user.put("role", "administrator");
        user.put("age", "35");

        assertTrue(complex.matches(user));
    }


    @Test
    void complexTreeRejectsSpamUser() {

        Filter adminOlderThan30 = new AndFilter(
                new EqualsFilter("role", "administrator"),
                new isGreaterFilter("age", "30")
        );

        Filter validEmail = new AndFilter(
                new isPresent("email"),
                new NotFilter(new RegexFilter("email", ".*@spam\\.com"))
        );

        Filter complex = new OrFilter(adminOlderThan30, validEmail);

        Map<String, String> spamUser = new java.util.HashMap<>();
        spamUser.put("email", "spam@spam.com");
        spamUser.put("role", "administrator");
        spamUser.put("age", "30");

        assertFalse(complex.matches(spamUser));
    }
}
