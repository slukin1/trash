package kotlin.jvm.internal;

import kotlin.reflect.b;
import kotlin.reflect.i;
import kotlin.reflect.m;

public abstract class MutablePropertyReference0 extends MutablePropertyReference implements i {
    public MutablePropertyReference0() {
    }

    public b computeReflected() {
        return Reflection.d(this);
    }

    public abstract /* synthetic */ Object get();

    public Object getDelegate() {
        return ((i) getReflected()).getDelegate();
    }

    public Object invoke() {
        return get();
    }

    public abstract /* synthetic */ void set(Object obj);

    public MutablePropertyReference0(Object obj) {
        super(obj);
    }

    public m.a getGetter() {
        return ((i) getReflected()).getGetter();
    }

    public i.a getSetter() {
        return ((i) getReflected()).getSetter();
    }

    public MutablePropertyReference0(Object obj, Class cls, String str, String str2, int i11) {
        super(obj, cls, str, str2, i11);
    }
}
