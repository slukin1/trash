package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ListIterator;

@GwtCompatible
public abstract class ForwardingListIterator<E> extends ForwardingIterator<E> implements ListIterator<E> {
    public void add(E e11) {
        delegate().add(e11);
    }

    public abstract ListIterator<E> delegate();

    public boolean hasPrevious() {
        return delegate().hasPrevious();
    }

    public int nextIndex() {
        return delegate().nextIndex();
    }

    @CanIgnoreReturnValue
    public E previous() {
        return delegate().previous();
    }

    public int previousIndex() {
        return delegate().previousIndex();
    }

    public void set(E e11) {
        delegate().set(e11);
    }
}
