package kotlin.reflect;

import d10.p;
import kotlin.Unit;

public interface j<T, V> extends n<T, V>, l {

    public interface a<T, V> extends h<V>, p<T, V, Unit> {
    }

    a<T, V> getSetter();
}
