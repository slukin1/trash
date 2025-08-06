package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@GwtCompatible
abstract class AbstractMultiset<E> extends AbstractCollection<E> implements Multiset<E> {
    private transient Set<E> elementSet;
    private transient Set<Multiset.Entry<E>> entrySet;

    public class ElementSet extends Multisets.ElementSet<E> {
        public ElementSet() {
        }

        public Iterator<E> iterator() {
            return AbstractMultiset.this.elementIterator();
        }

        public Multiset<E> multiset() {
            return AbstractMultiset.this;
        }
    }

    public class EntrySet extends Multisets.EntrySet<E> {
        public EntrySet() {
        }

        public Iterator<Multiset.Entry<E>> iterator() {
            return AbstractMultiset.this.entryIterator();
        }

        public Multiset<E> multiset() {
            return AbstractMultiset.this;
        }

        public int size() {
            return AbstractMultiset.this.distinctElements();
        }
    }

    @CanIgnoreReturnValue
    public final boolean add(E e11) {
        add(e11, 1);
        return true;
    }

    @CanIgnoreReturnValue
    public final boolean addAll(Collection<? extends E> collection) {
        return Multisets.addAllImpl(this, collection);
    }

    public abstract void clear();

    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    public Set<E> createElementSet() {
        return new ElementSet();
    }

    public Set<Multiset.Entry<E>> createEntrySet() {
        return new EntrySet();
    }

    public abstract int distinctElements();

    public abstract Iterator<E> elementIterator();

    public Set<E> elementSet() {
        Set<E> set = this.elementSet;
        if (set != null) {
            return set;
        }
        Set<E> createElementSet = createElementSet();
        this.elementSet = createElementSet;
        return createElementSet;
    }

    public abstract Iterator<Multiset.Entry<E>> entryIterator();

    public Set<Multiset.Entry<E>> entrySet() {
        Set<Multiset.Entry<E>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        Set<Multiset.Entry<E>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    public final boolean equals(Object obj) {
        return Multisets.equalsImpl(this, obj);
    }

    public final int hashCode() {
        return entrySet().hashCode();
    }

    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @CanIgnoreReturnValue
    public final boolean remove(Object obj) {
        return remove(obj, 1) > 0;
    }

    @CanIgnoreReturnValue
    public final boolean removeAll(Collection<?> collection) {
        return Multisets.removeAllImpl(this, collection);
    }

    @CanIgnoreReturnValue
    public final boolean retainAll(Collection<?> collection) {
        return Multisets.retainAllImpl(this, collection);
    }

    @CanIgnoreReturnValue
    public int setCount(E e11, int i11) {
        return Multisets.setCountImpl(this, e11, i11);
    }

    public final String toString() {
        return entrySet().toString();
    }

    @CanIgnoreReturnValue
    public int add(E e11, int i11) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    public int remove(Object obj, int i11) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    public boolean setCount(E e11, int i11, int i12) {
        return Multisets.setCountImpl(this, e11, i11, i12);
    }
}
