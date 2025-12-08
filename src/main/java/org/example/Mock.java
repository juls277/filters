package org.example;
import org.example.comparison.*;
import org.example.logical.*;
import org.example.booleans.*;
import java.util.Map;
import org.example.visitor.*;

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

        Filter complex_tree = new AndFilter(
                new EqualsFilter("role", "admin"),
                new OrFilter(new TrueFilter(), new NotFilter(new FalseFilter()))
        );
        int count = complex_tree.accept(new CountFilterVisitor());
        System.out.println(count); // i expect output 6
    }
}
