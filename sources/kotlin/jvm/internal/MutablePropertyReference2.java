package kotlin.jvm.internal;

import kotlin.reflect.b;
import kotlin.reflect.k;
import kotlin.reflect.o;

public abstract class MutablePropertyReference2 extends MutablePropertyReference implements k {
    public MutablePropertyReference2() {
    }

    public b computeReflected() {
        return Reflection.f(this);
    }

    public abstract /* synthetic */ Object get(Object obj, Object obj2);

    public Object getDelegate(Object obj, Object obj2) {
        return ((k) getReflected()).getDelegate(obj, obj2);
    }

    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    public abstract /* synthetic */ void set(Object obj, Object obj2, Object obj3);

    public MutablePropertyReference2(Class cls, String str, String str2, int i11) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i11);
    }

    public o.a getGetter() {
        return ((k) getReflected()).getGetter();
    }

    public k.a getSetter() {
        return ((k) getReflected()).getSetter();
    }
}
