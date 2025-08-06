package kotlin.collections;

import e10.a;
import java.util.Iterator;

public abstract class ShortIterator implements Iterator<Short>, a {
    public abstract short a();

    public /* bridge */ /* synthetic */ Object next() {
        return Short.valueOf(a());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
