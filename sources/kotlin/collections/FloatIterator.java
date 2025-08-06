package kotlin.collections;

import e10.a;
import java.util.Iterator;

public abstract class FloatIterator implements Iterator<Float>, a {
    public abstract float a();

    public /* bridge */ /* synthetic */ Object next() {
        return Float.valueOf(a());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
