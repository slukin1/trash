package kotlin.collections;

import java.util.AbstractList;

public abstract class d<E> extends AbstractList<E> implements e10.d {
    public abstract void add(int i11, E e11);

    public abstract int getSize();

    public final /* bridge */ E remove(int i11) {
        return removeAt(i11);
    }

    public abstract E removeAt(int i11);

    public abstract E set(int i11, E e11);

    public final /* bridge */ int size() {
        return getSize();
    }
}
