package kotlin.jvm.internal;

import kotlin.reflect.c;
import kotlin.reflect.f;

public class MutablePropertyReference2Impl extends MutablePropertyReference2 {
    public MutablePropertyReference2Impl(f fVar, String str, String str2) {
        super(((o) fVar).e(), str, str2, (fVar instanceof c) ^ true ? 1 : 0);
    }

    public Object get(Object obj, Object obj2) {
        return getGetter().call(obj, obj2);
    }

    public void set(Object obj, Object obj2, Object obj3) {
        getSetter().call(obj, obj2, obj3);
    }

    public MutablePropertyReference2Impl(Class cls, String str, String str2, int i11) {
        super(cls, str, str2, i11);
    }
}
