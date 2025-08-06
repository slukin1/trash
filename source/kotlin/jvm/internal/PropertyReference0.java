package kotlin.jvm.internal;

import kotlin.reflect.b;
import kotlin.reflect.m;

public abstract class PropertyReference0 extends PropertyReference implements m {
    public PropertyReference0() {
    }

    public b computeReflected() {
        return Reflection.i(this);
    }

    public abstract /* synthetic */ Object get();

    public Object getDelegate() {
        return ((m) getReflected()).getDelegate();
    }

    public Object invoke() {
        return get();
    }

    public PropertyReference0(Object obj) {
        super(obj);
    }

    public m.a getGetter() {
        return ((m) getReflected()).getGetter();
    }

    public PropertyReference0(Object obj, Class cls, String str, String str2, int i11) {
        super(obj, cls, str, str2, i11);
    }
}
