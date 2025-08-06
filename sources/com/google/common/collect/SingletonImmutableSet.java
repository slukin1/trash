package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;

@GwtCompatible(emulated = true, serializable = true)
final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    @LazyInit
    private transient int cachedHashCode;
    public final transient E element;

    public SingletonImmutableSet(E e11) {
        this.element = Preconditions.checkNotNull(e11);
    }

    public boolean contains(Object obj) {
        return this.element.equals(obj);
    }

    public int copyIntoArray(Object[] objArr, int i11) {
        objArr[i11] = this.element;
        return i11 + 1;
    }

    public ImmutableList<E> createAsList() {
        return ImmutableList.of(this.element);
    }

    public final int hashCode() {
        int i11 = this.cachedHashCode;
        if (i11 != 0) {
            return i11;
        }
        int hashCode = this.element.hashCode();
        this.cachedHashCode = hashCode;
        return hashCode;
    }

    public boolean isHashCodeFast() {
        return this.cachedHashCode != 0;
    }

    public boolean isPartialView() {
        return false;
    }

    public int size() {
        return 1;
    }

    public String toString() {
        return '[' + this.element.toString() + ']';
    }

    public UnmodifiableIterator<E> iterator() {
        return Iterators.singletonIterator(this.element);
    }

    public SingletonImmutableSet(E e11, int i11) {
        this.element = e11;
        this.cachedHashCode = i11;
    }
}
