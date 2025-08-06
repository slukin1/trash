package androidx.test.espresso.core.internal.deps.guava.collect;

import java.util.NoSuchElementException;

public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {

    /* renamed from: b  reason: collision with root package name */
    public T f11307b;

    public AbstractSequentialIterator(T t11) {
        this.f11307b = t11;
    }

    public abstract T a(T t11);

    public final boolean hasNext() {
        return this.f11307b != null;
    }

    public final T next() {
        if (hasNext()) {
            try {
                T t11 = this.f11307b;
                this.f11307b = a(t11);
                return t11;
            } catch (Throwable th2) {
                this.f11307b = a(this.f11307b);
                throw th2;
            }
        } else {
            throw new NoSuchElementException();
        }
    }
}
