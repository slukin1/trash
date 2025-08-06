package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;

final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    private transient int cachedHashCode;
    public final transient E element;

    public SingletonImmutableSet(E e11) {
        this.element = Preconditions.i(e11);
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

    public int size() {
        return 1;
    }

    public String toString() {
        String obj = this.element.toString();
        StringBuilder sb2 = new StringBuilder(String.valueOf(obj).length() + 2);
        sb2.append('[');
        sb2.append(obj);
        sb2.append(']');
        return sb2.toString();
    }

    public UnmodifiableIterator<E> iterator() {
        return Iterators.d(this.element);
    }

    public SingletonImmutableSet(E e11, int i11) {
        this.element = e11;
        this.cachedHashCode = i11;
    }
}
