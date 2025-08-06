package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@GwtCompatible
public abstract class ForwardingList<E> extends ForwardingCollection<E> implements List<E> {
    public void add(int i11, E e11) {
        delegate().add(i11, e11);
    }

    @CanIgnoreReturnValue
    public boolean addAll(int i11, Collection<? extends E> collection) {
        return delegate().addAll(i11, collection);
    }

    public abstract List<E> delegate();

    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    public E get(int i11) {
        return delegate().get(i11);
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    public int indexOf(Object obj) {
        return delegate().indexOf(obj);
    }

    public int lastIndexOf(Object obj) {
        return delegate().lastIndexOf(obj);
    }

    public ListIterator<E> listIterator() {
        return delegate().listIterator();
    }

    @CanIgnoreReturnValue
    public E remove(int i11) {
        return delegate().remove(i11);
    }

    @CanIgnoreReturnValue
    public E set(int i11, E e11) {
        return delegate().set(i11, e11);
    }

    public boolean standardAdd(E e11) {
        add(size(), e11);
        return true;
    }

    public boolean standardAddAll(int i11, Iterable<? extends E> iterable) {
        return Lists.addAllImpl(this, i11, iterable);
    }

    @Beta
    public boolean standardEquals(Object obj) {
        return Lists.equalsImpl(this, obj);
    }

    @Beta
    public int standardHashCode() {
        return Lists.hashCodeImpl(this);
    }

    public int standardIndexOf(Object obj) {
        return Lists.indexOfImpl(this, obj);
    }

    public Iterator<E> standardIterator() {
        return listIterator();
    }

    public int standardLastIndexOf(Object obj) {
        return Lists.lastIndexOfImpl(this, obj);
    }

    public ListIterator<E> standardListIterator() {
        return listIterator(0);
    }

    @Beta
    public List<E> standardSubList(int i11, int i12) {
        return Lists.subListImpl(this, i11, i12);
    }

    public List<E> subList(int i11, int i12) {
        return delegate().subList(i11, i12);
    }

    public ListIterator<E> listIterator(int i11) {
        return delegate().listIterator(i11);
    }

    @Beta
    public ListIterator<E> standardListIterator(int i11) {
        return Lists.listIteratorImpl(this, i11);
    }
}
