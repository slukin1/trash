package kotlin.collections;

import e10.a;
import java.util.Iterator;

public abstract class BooleanIterator implements Iterator<Boolean>, a {
    public abstract boolean a();

    public /* bridge */ /* synthetic */ Object next() {
        return Boolean.valueOf(a());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
