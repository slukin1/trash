package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;

@GwtCompatible
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {
    private T nextOrNull;

    public AbstractSequentialIterator(T t11) {
        this.nextOrNull = t11;
    }

    public abstract T computeNext(T t11);

    public final boolean hasNext() {
        return this.nextOrNull != null;
    }

    public final T next() {
        if (hasNext()) {
            try {
                T t11 = this.nextOrNull;
                this.nextOrNull = computeNext(t11);
                return t11;
            } catch (Throwable th2) {
                this.nextOrNull = computeNext(this.nextOrNull);
                throw th2;
            }
        } else {
            throw new NoSuchElementException();
        }
    }
}
