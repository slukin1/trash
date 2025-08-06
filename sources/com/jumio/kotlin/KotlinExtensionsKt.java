package com.jumio.kotlin;

import d10.p;
import d10.q;
import d10.r;

public final class KotlinExtensionsKt {
    public static final <T1, T2, R> R safeLet(T1 t12, T2 t22, p<? super T1, ? super T2, ? extends R> pVar) {
        if (t12 == null || t22 == null) {
            return null;
        }
        return pVar.invoke(t12, t22);
    }

    public static final <T1, T2, T3, R> R safeLet(T1 t12, T2 t22, T3 t32, q<? super T1, ? super T2, ? super T3, ? extends R> qVar) {
        if (t12 == null || t22 == null || t32 == null) {
            return null;
        }
        return qVar.invoke(t12, t22, t32);
    }

    public static final <T1, T2, T3, T4, R> R safeLet(T1 t12, T2 t22, T3 t32, T4 t42, r<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> rVar) {
        if (t12 == null || t22 == null || t32 == null || t42 == null) {
            return null;
        }
        return rVar.invoke(t12, t22, t32, t42);
    }
}
