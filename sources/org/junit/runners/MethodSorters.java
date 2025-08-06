package org.junit.runners;

import java.lang.reflect.Method;
import java.util.Comparator;
import q20.a;

public enum MethodSorters {
    NAME_ASCENDING(a.f25599b),
    JVM((String) null),
    DEFAULT(a.f25598a);
    
    private final Comparator<Method> comparator;

    private MethodSorters(Comparator<Method> comparator2) {
        this.comparator = comparator2;
    }

    public Comparator<Method> getComparator() {
        return this.comparator;
    }
}
