package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

@GwtCompatible
public abstract class ForwardingSortedSet<E> extends ForwardingSet<E> implements SortedSet<E> {
    private int unsafeCompare(Object obj, Object obj2) {
        Comparator comparator = comparator();
        if (comparator == null) {
            return ((Comparable) obj).compareTo(obj2);
        }
        return comparator.compare(obj, obj2);
    }

    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    public abstract SortedSet<E> delegate();

    public E first() {
        return delegate().first();
    }

    public SortedSet<E> headSet(E e11) {
        return delegate().headSet(e11);
    }

    public E last() {
        return delegate().last();
    }

    @Beta
    public boolean standardContains(Object obj) {
        try {
            if (unsafeCompare(tailSet(obj).first(), obj) == 0) {
                return true;
            }
            return false;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    @Beta
    public boolean standardRemove(Object obj) {
        try {
            Iterator it2 = tailSet(obj).iterator();
            if (it2.hasNext() && unsafeCompare(it2.next(), obj) == 0) {
                it2.remove();
                return true;
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    @Beta
    public SortedSet<E> standardSubSet(E e11, E e12) {
        return tailSet(e11).headSet(e12);
    }

    public SortedSet<E> subSet(E e11, E e12) {
        return delegate().subSet(e11, e12);
    }

    public SortedSet<E> tailSet(E e11) {
        return delegate().tailSet(e11);
    }
}
