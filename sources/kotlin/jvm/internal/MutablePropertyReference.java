package kotlin.jvm.internal;

import kotlin.reflect.h;
import kotlin.reflect.l;

public abstract class MutablePropertyReference extends PropertyReference {
    public MutablePropertyReference() {
    }

    public abstract /* synthetic */ l.a getGetter();

    public abstract /* synthetic */ h getSetter();

    public MutablePropertyReference(Object obj) {
        super(obj);
    }

    public MutablePropertyReference(Object obj, Class cls, String str, String str2, int i11) {
        super(obj, cls, str, str2, i11);
    }
}
