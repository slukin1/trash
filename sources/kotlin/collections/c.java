package kotlin.collections;

import e10.b;
import java.util.AbstractCollection;

public abstract class c<E> extends AbstractCollection<E> implements b {
    public abstract int a();

    public final /* bridge */ int size() {
        return a();
    }
}
