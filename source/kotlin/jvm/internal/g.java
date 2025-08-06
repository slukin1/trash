package kotlin.jvm.internal;

import e10.a;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class g<T> implements Iterator<T>, a {

    /* renamed from: b  reason: collision with root package name */
    public final T[] f56779b;

    /* renamed from: c  reason: collision with root package name */
    public int f56780c;

    public g(T[] tArr) {
        this.f56779b = tArr;
    }

    public boolean hasNext() {
        return this.f56780c < this.f56779b.length;
    }

    public T next() {
        try {
            T[] tArr = this.f56779b;
            int i11 = this.f56780c;
            this.f56780c = i11 + 1;
            return tArr[i11];
        } catch (ArrayIndexOutOfBoundsException e11) {
            this.f56780c--;
            throw new NoSuchElementException(e11.getMessage());
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
