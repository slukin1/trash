package kotlin.jvm.internal;

import kotlin.reflect.b;
import kotlin.reflect.n;

public abstract class PropertyReference1 extends PropertyReference implements n {
    public PropertyReference1() {
    }

    public b computeReflected() {
        return Reflection.j(this);
    }

    public abstract /* synthetic */ Object get(Object obj);

    public Object getDelegate(Object obj) {
        return ((n) getReflected()).getDelegate(obj);
    }

    public Object invoke(Object obj) {
        return get(obj);
    }

    public PropertyReference1(Object obj) {
        super(obj);
    }

    public n.a getGetter() {
        return ((n) getReflected()).getGetter();
    }

    public PropertyReference1(Object obj, Class cls, String str, String str2, int i11) {
        super(obj, cls, str, str2, i11);
    }
}
