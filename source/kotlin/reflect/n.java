package kotlin.reflect;

import d10.l;
import kotlin.reflect.l;

public interface n<T, V> extends l<V>, l<T, V> {

    public interface a<T, V> extends l.a<V>, d10.l<T, V> {
    }

    Object getDelegate(T t11);

    a<T, V> getGetter();
}
