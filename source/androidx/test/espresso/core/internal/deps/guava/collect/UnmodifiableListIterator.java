package androidx.test.espresso.core.internal.deps.guava.collect;

import java.util.ListIterator;

public abstract class UnmodifiableListIterator<E> extends UnmodifiableIterator<E> implements ListIterator<E> {
    @Deprecated
    public final void add(E e11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void set(E e11) {
        throw new UnsupportedOperationException();
    }
}
