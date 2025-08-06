package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;

@GwtCompatible(serializable = true)
final class ReverseNaturalOrdering extends Ordering<Comparable> implements Serializable {
    public static final ReverseNaturalOrdering INSTANCE = new ReverseNaturalOrdering();
    private static final long serialVersionUID = 0;

    private ReverseNaturalOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public <S extends Comparable> Ordering<S> reverse() {
        return Ordering.natural();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    public int compare(Comparable comparable, Comparable comparable2) {
        Preconditions.checkNotNull(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public <E extends Comparable> E max(E e11, E e12) {
        return (Comparable) NaturalOrdering.INSTANCE.min(e11, e12);
    }

    public <E extends Comparable> E min(E e11, E e12) {
        return (Comparable) NaturalOrdering.INSTANCE.max(e11, e12);
    }

    public <E extends Comparable> E max(E e11, E e12, E e13, E... eArr) {
        return (Comparable) NaturalOrdering.INSTANCE.min(e11, e12, e13, eArr);
    }

    public <E extends Comparable> E min(E e11, E e12, E e13, E... eArr) {
        return (Comparable) NaturalOrdering.INSTANCE.max(e11, e12, e13, eArr);
    }

    public <E extends Comparable> E max(Iterator<E> it2) {
        return (Comparable) NaturalOrdering.INSTANCE.min(it2);
    }

    public <E extends Comparable> E min(Iterator<E> it2) {
        return (Comparable) NaturalOrdering.INSTANCE.max(it2);
    }

    public <E extends Comparable> E max(Iterable<E> iterable) {
        return (Comparable) NaturalOrdering.INSTANCE.min(iterable);
    }

    public <E extends Comparable> E min(Iterable<E> iterable) {
        return (Comparable) NaturalOrdering.INSTANCE.max(iterable);
    }
}
