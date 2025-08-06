package kotlin.jvm.internal;

import kotlin.reflect.b;
import kotlin.reflect.o;

public abstract class PropertyReference2 extends PropertyReference implements o {
    public PropertyReference2() {
    }

    public b computeReflected() {
        return Reflection.k(this);
    }

    public abstract /* synthetic */ Object get(Object obj, Object obj2);

    public Object getDelegate(Object obj, Object obj2) {
        return ((o) getReflected()).getDelegate(obj, obj2);
    }

    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    public PropertyReference2(Class cls, String str, String str2, int i11) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i11);
    }

    public o.a getGetter() {
        return ((o) getReflected()).getGetter();
    }
}
