package kotlin.collections;

import e10.a;
import java.util.Iterator;

public abstract class IntIterator implements Iterator<Integer>, a {
    public abstract int a();

    public /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(a());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
