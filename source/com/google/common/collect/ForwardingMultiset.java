package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@GwtCompatible
public abstract class ForwardingMultiset<E> extends ForwardingCollection<E> implements Multiset<E> {

    @Beta
    public class StandardElementSet extends Multisets.ElementSet<E> {
        public StandardElementSet() {
        }

        public Iterator<E> iterator() {
            return Multisets.elementIterator(multiset().entrySet().iterator());
        }

        public Multiset<E> multiset() {
            return ForwardingMultiset.this;
        }
    }

    @CanIgnoreReturnValue
    public int add(E e11, int i11) {
        return delegate().add(e11, i11);
    }

    public int count(Object obj) {
        return delegate().count(obj);
    }

    public abstract Multiset<E> delegate();

    public Set<E> elementSet() {
        return delegate().elementSet();
    }

    public Set<Multiset.Entry<E>> entrySet() {
        return delegate().entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    @CanIgnoreReturnValue
    public int remove(Object obj, int i11) {
        return delegate().remove(obj, i11);
    }

    @CanIgnoreReturnValue
    public int setCount(E e11, int i11) {
        return delegate().setCount(e11, i11);
    }

    public boolean standardAdd(E e11) {
        add(e11, 1);
        return true;
    }

    @Beta
    public boolean standardAddAll(Collection<? extends E> collection) {
        return Multisets.addAllImpl(this, collection);
    }

    public void standardClear() {
        Iterators.clear(entrySet().iterator());
    }

    public boolean standardContains(Object obj) {
        return count(obj) > 0;
    }

    @Beta
    public int standardCount(Object obj) {
        for (Multiset.Entry entry : entrySet()) {
            if (Objects.equal(entry.getElement(), obj)) {
                return entry.getCount();
            }
        }
        return 0;
    }

    public boolean standardEquals(Object obj) {
        return Multisets.equalsImpl(this, obj);
    }

    public int standardHashCode() {
        return entrySet().hashCode();
    }

    public Iterator<E> standardIterator() {
        return Multisets.iteratorImpl(this);
    }

    public boolean standardRemove(Object obj) {
        return remove(obj, 1) > 0;
    }

    public boolean standardRemoveAll(Collection<?> collection) {
        return Multisets.removeAllImpl(this, collection);
    }

    public boolean standardRetainAll(Collection<?> collection) {
        return Multisets.retainAllImpl(this, collection);
    }

    public int standardSetCount(E e11, int i11) {
        return Multisets.setCountImpl(this, e11, i11);
    }

    public int standardSize() {
        return Multisets.linearTimeSizeImpl(this);
    }

    public String standardToString() {
        return entrySet().toString();
    }

    @CanIgnoreReturnValue
    public boolean setCount(E e11, int i11, int i12) {
        return delegate().setCount(e11, i11, i12);
    }

    public boolean standardSetCount(E e11, int i11, int i12) {
        return Multisets.setCountImpl(this, e11, i11, i12);
    }
}
