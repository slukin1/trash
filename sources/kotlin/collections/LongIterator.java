package kotlin.collections;

import e10.a;
import java.util.Iterator;

public abstract class LongIterator implements Iterator<Long>, a {
    public abstract long a();

    public /* bridge */ /* synthetic */ Object next() {
        return Long.valueOf(a());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
