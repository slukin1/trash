package androidx.test.espresso.core.internal.deps.guava.collect;

import java.util.Iterator;

public abstract class UnmodifiableIterator<E> implements Iterator<E> {
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
