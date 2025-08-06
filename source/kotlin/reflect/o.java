package kotlin.reflect;

import d10.p;
import kotlin.reflect.l;

public interface o<D, E, V> extends l<V>, p<D, E, V> {

    public interface a<D, E, V> extends l.a<V>, p<D, E, V> {
    }

    Object getDelegate(D d11, E e11);

    a<D, E, V> getGetter();
}
