package org.example;
import org.example.comparison.*;
import org.example.logical.*;
import org.example.booleans.*;
import java.util.Map;

public class Mock {
    public static void main (String[] args) {
        Map<String, String> user = new java.util.HashMap<>();
        user.put("firstname", "Joe");
        user.put("lastname", "Bloggs");
        user.put("role", "administrator");
        user.put("age", "35");



        Filter alwaysTrue = new TrueFilter();
        Filter alwaysFalse = new FalseFilter();

        System.out.println(alwaysTrue.matches(user));
        System.out.println(alwaysFalse.matches(user));


        Filter combined = new AndFilter(alwaysTrue, alwaysFalse);
        System.out.println(combined);
        System.out.println(combined.matches(user));

        Filter f = new AndFilter(
                new EqualsFilter("ROLE", "ADMINISTRATOR"),
                new isGreaterFilter("age", "30")
        );
        System.out.println(f);

       /* Filter is_matches = new EqualsFilter("role", "ADMINISTRATOR");
        System.out.println("Matches " + is_matches.matches(user));

        Filter is_greater = new isGreaterFilter("age", "13");
        System.out.println("Matches " + is_greater.matches(user));

        Filter is_present = new isPresent("lastname");
        System.out.println("Matches " + is_present.matches(user));*/

    }
}
