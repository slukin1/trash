package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.NoSuchElementException;

abstract class AbstractIndexedListIterator<E> extends UnmodifiableListIterator<E> {

    /* renamed from: b  reason: collision with root package name */
    public final int f11302b;

    /* renamed from: c  reason: collision with root package name */
    public int f11303c;

    public AbstractIndexedListIterator(int i11, int i12) {
        Preconditions.l(i12, i11);
        this.f11302b = i11;
        this.f11303c = i12;
    }

    public abstract E a(int i11);

    public final boolean hasNext() {
        return this.f11303c < this.f11302b;
    }

    public final boolean hasPrevious() {
        return this.f11303c > 0;
    }

    public final E next() {
        if (hasNext()) {
            int i11 = this.f11303c;
            this.f11303c = i11 + 1;
            return a(i11);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f11303c;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i11 = this.f11303c - 1;
            this.f11303c = i11;
            return a(i11);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f11303c - 1;
    }
}
