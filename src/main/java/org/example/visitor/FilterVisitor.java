package org.example.visitor;

import org.example.booleans.FalseFilter;
import org.example.booleans.TrueFilter;
import org.example.logical.*;
import org.example.comparison.*;



public interface FilterVisitor<R> {

    R visit(TrueFilter filter);
    R visit(FalseFilter filter);

    R visit(AndFilter filter);
    R visit(NotFilter filter);
    R visit(OrFilter filter);

    R visit(EqualsFilter filter);
    R visit(isGreaterFilter filter);
    R visit(IsLessFilter Filter);
    R visit(isPresent Filter);
    R visit(RegexFilter filter);



}