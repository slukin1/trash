package kotlin.jvm.internal;

import kotlin.reflect.b;
import kotlin.reflect.j;
import kotlin.reflect.n;

public abstract class MutablePropertyReference1 extends MutablePropertyReference implements j {
    public MutablePropertyReference1() {
    }

    public b computeReflected() {
        return Reflection.e(this);
    }

    public abstract /* synthetic */ Object get(Object obj);

    public Object getDelegate(Object obj) {
        return ((j) getReflected()).getDelegate(obj);
    }

    public Object invoke(Object obj) {
        return get(obj);
    }

    public abstract /* synthetic */ void set(Object obj, Object obj2);

    public MutablePropertyReference1(Object obj) {
        super(obj);
    }

    public n.a getGetter() {
        return ((j) getReflected()).getGetter();
    }

    public j.a getSetter() {
        return ((j) getReflected()).getSetter();
    }

    public MutablePropertyReference1(Object obj, Class cls, String str, String str2, int i11) {
        super(obj, cls, str, str2, i11);
    }
}
