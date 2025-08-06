package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;

@GwtCompatible(serializable = true)
final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    public final Ordering<? super T> forwardOrder;

    public ReverseOrdering(Ordering<? super T> ordering) {
        this.forwardOrder = (Ordering) Preconditions.checkNotNull(ordering);
    }

    public int compare(T t11, T t12) {
        return this.forwardOrder.compare(t12, t11);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReverseOrdering) {
            return this.forwardOrder.equals(((ReverseOrdering) obj).forwardOrder);
        }
        return false;
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    public <E extends T> E max(E e11, E e12) {
        return this.forwardOrder.min(e11, e12);
    }

    public <E extends T> E min(E e11, E e12) {
        return this.forwardOrder.max(e11, e12);
    }

    public <S extends T> Ordering<S> reverse() {
        return this.forwardOrder;
    }

    public String toString() {
        return this.forwardOrder + ".reverse()";
    }

    public <E extends T> E max(E e11, E e12, E e13, E... eArr) {
        return this.forwardOrder.min(e11, e12, e13, eArr);
    }

    public <E extends T> E min(E e11, E e12, E e13, E... eArr) {
        return this.forwardOrder.max(e11, e12, e13, eArr);
    }

    public <E extends T> E max(Iterator<E> it2) {
        return this.forwardOrder.min(it2);
    }

    public <E extends T> E min(Iterator<E> it2) {
        return this.forwardOrder.max(it2);
    }

    public <E extends T> E max(Iterable<E> iterable) {
        return this.forwardOrder.min(iterable);
    }

    public <E extends T> E min(Iterable<E> iterable) {
        return this.forwardOrder.max(iterable);
    }
}
