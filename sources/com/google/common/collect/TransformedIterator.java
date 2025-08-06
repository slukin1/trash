package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Iterator;

@GwtCompatible
abstract class TransformedIterator<F, T> implements Iterator<T> {
    public final Iterator<? extends F> backingIterator;

    public TransformedIterator(Iterator<? extends F> it2) {
        this.backingIterator = (Iterator) Preconditions.checkNotNull(it2);
    }

    public final boolean hasNext() {
        return this.backingIterator.hasNext();
    }

    public final T next() {
        return transform(this.backingIterator.next());
    }

    public final void remove() {
        this.backingIterator.remove();
    }

    /* access modifiers changed from: package-private */
    public abstract T transform(F f11);
}
