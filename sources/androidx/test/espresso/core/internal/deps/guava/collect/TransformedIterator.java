package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.Iterator;

abstract class TransformedIterator<F, T> implements Iterator<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Iterator<? extends F> f11324b;

    public TransformedIterator(Iterator<? extends F> it2) {
        this.f11324b = (Iterator) Preconditions.i(it2);
    }

    public abstract T a(F f11);

    public final boolean hasNext() {
        return this.f11324b.hasNext();
    }

    public final T next() {
        return a(this.f11324b.next());
    }

    public final void remove() {
        this.f11324b.remove();
    }
}
