package kotlin.collections;

import e10.a;
import java.util.Iterator;

public abstract class ByteIterator implements Iterator<Byte>, a {
    public /* bridge */ /* synthetic */ Object next() {
        return Byte.valueOf(nextByte());
    }

    public abstract byte nextByte();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
