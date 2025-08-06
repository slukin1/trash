package kotlin.jvm.internal;

import kotlin.reflect.c;
import kotlin.reflect.f;

public class PropertyReference2Impl extends PropertyReference2 {
    public PropertyReference2Impl(f fVar, String str, String str2) {
        super(((o) fVar).e(), str, str2, (fVar instanceof c) ^ true ? 1 : 0);
    }

    public Object get(Object obj, Object obj2) {
        return getGetter().call(obj, obj2);
    }

    public PropertyReference2Impl(Class cls, String str, String str2, int i11) {
        super(cls, str, str2, i11);
    }
}
