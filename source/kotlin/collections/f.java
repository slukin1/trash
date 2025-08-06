package kotlin.collections;

import e10.b;
import java.util.AbstractSet;

public abstract class f<E> extends AbstractSet<E> implements b {
    public abstract boolean add(E e11);

    public abstract int getSize();

    public final /* bridge */ int size() {
        return getSize();
    }
}
