package kotlin.collections;

import e10.a;
import java.util.Iterator;

public abstract class DoubleIterator implements Iterator<Double>, a {
    public abstract double a();

    public /* bridge */ /* synthetic */ Object next() {
        return Double.valueOf(a());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
