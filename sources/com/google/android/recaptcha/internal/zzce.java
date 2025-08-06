package com.google.android.recaptcha.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.Unit;
import kotlin.jvm.internal.x;

public abstract class zzce implements InvocationHandler {
    private final Object zza;

    public zzce(Object obj) {
        this.zza = obj;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        Object obj2;
        if (x.b(method.getName(), "toString") && method.getParameterTypes().length == 0) {
            return "Proxy@".concat(String.valueOf(Integer.toHexString(obj.hashCode())));
        }
        if (x.b(method.getName(), "hashCode") && method.getParameterTypes().length == 0) {
            return Integer.valueOf(System.identityHashCode(obj));
        }
        if (x.b(method.getName(), "equals") && method.getParameterTypes().length != 0) {
            boolean z11 = false;
            if (!(objArr == null || objArr.length == 0)) {
                Object obj3 = objArr[0];
                if ((obj3 != null ? obj3.hashCode() : 0) == obj.hashCode()) {
                    z11 = true;
                }
            }
            return Boolean.valueOf(z11);
        } else if (!zza(obj, method, objArr)) {
            return Unit.f56620a;
        } else {
            if ((this.zza != null || !x.b(method.getReturnType(), Void.TYPE)) && ((obj2 = this.zza) == null || !x.b(zzgd.zza(obj2.getClass()), zzgd.zza(method.getReturnType())))) {
                Object obj4 = this.zza;
                Class<?> returnType = method.getReturnType();
                throw new IllegalArgumentException(obj4 + " cannot be returned from method with return type " + returnType);
            }
            Object obj5 = this.zza;
            return obj5 == null ? Unit.f56620a : obj5;
        }
    }

    public abstract boolean zza(Object obj, Method method, Object[] objArr);
}
