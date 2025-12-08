package org.example.visitor;

import org.example.booleans.FalseFilter;
import org.example.booleans.TrueFilter;
import org.example.logical.*;
import org.example.comparison.*;
import org.example.visitor.FilterVisitor;

public class CountFilterVisitor implements FilterVisitor<Integer> {

    @Override
    public Integer visit(TrueFilter filter) {
        return 1;
    }

    @Override
    public Integer visit(FalseFilter filter) {
        return 1;
    }

    @Override
    public Integer visit(EqualsFilter filter) {
        return 1;
    }

    @Override
    public Integer visit(AndFilter filter) {
        return 1
                + filter.getLeft().accept(this)
                + filter.getRight().accept(this);
    }

    @Override
    public Integer visit(OrFilter filter) {
        return 1
                + filter.getLeft().accept(this)
                + filter.getRight().accept(this);
    }

    @Override
    public Integer visit(NotFilter filter) {
        return 1 + filter.getProperty().accept(this);
    }
    @Override
    public Integer visit(isGreaterFilter filter) {
        return 1;
    }

    @Override
    public Integer visit(IsLessFilter filter) {
        return 1;
    }

    @Override
    public Integer visit(isPresent filter) {
        return 1;
    }

    @Override
    public Integer visit(RegexFilter filter) {
        return 1;
    }

}
