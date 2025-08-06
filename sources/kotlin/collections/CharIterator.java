package kotlin.collections;

import e10.a;
import java.util.Iterator;

public abstract class CharIterator implements Iterator<Character>, a {
    public abstract char a();

    public /* bridge */ /* synthetic */ Object next() {
        return Character.valueOf(a());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
