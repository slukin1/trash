package com.squareup.wire;

import com.squareup.wire.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class e<E extends f> extends a<E> {

    /* renamed from: s  reason: collision with root package name */
    public final Class<E> f30203s;

    /* renamed from: t  reason: collision with root package name */
    public Method f30204t;

    public e(Class<E> cls) {
        super(cls);
        this.f30203s = cls;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((e) obj).f30203s == this.f30203s;
    }

    public int hashCode() {
        return this.f30203s.hashCode();
    }

    public E u(int i11) {
        try {
            return (f) v().invoke((Object) null, new Object[]{Integer.valueOf(i11)});
        } catch (IllegalAccessException | InvocationTargetException e11) {
            throw new AssertionError(e11);
        }
    }

    public final Method v() {
        Method method = this.f30204t;
        if (method != null) {
            return method;
        }
        try {
            Method method2 = this.f30203s.getMethod("fromValue", new Class[]{Integer.TYPE});
            this.f30204t = method2;
            return method2;
        } catch (NoSuchMethodException e11) {
            throw new AssertionError(e11);
        }
    }
}
