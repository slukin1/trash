package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

@GwtCompatible
abstract class AbstractIndexedListIterator<E> extends UnmodifiableListIterator<E> {
    private int position;
    private final int size;

    public AbstractIndexedListIterator(int i11) {
        this(i11, 0);
    }

    public abstract E get(int i11);

    public final boolean hasNext() {
        return this.position < this.size;
    }

    public final boolean hasPrevious() {
        return this.position > 0;
    }

    public final E next() {
        if (hasNext()) {
            int i11 = this.position;
            this.position = i11 + 1;
            return get(i11);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.position;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i11 = this.position - 1;
            this.position = i11;
            return get(i11);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.position - 1;
    }

    public AbstractIndexedListIterator(int i11, int i12) {
        Preconditions.checkPositionIndex(i12, i11);
        this.size = i11;
        this.position = i12;
    }
}
