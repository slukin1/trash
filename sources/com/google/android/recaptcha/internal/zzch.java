package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.List;
import kotlin.jvm.internal.x;

public final class zzch extends zzce {
    private final zzcg zza;
    private final String zzb;

    public zzch(zzcg zzcg, String str, Object obj) {
        super(obj);
        this.zza = zzcg;
        this.zzb = str;
    }

    public final boolean zza(Object obj, Method method, Object[] objArr) {
        List list;
        if (!x.b(method.getName(), this.zzb)) {
            return false;
        }
        zzcg zzcg = this.zza;
        if (objArr == null || (list = ArraysKt___ArraysJvmKt.d(objArr)) == null) {
            list = CollectionsKt__CollectionsKt.k();
        }
        zzcg.zzb(list);
        return true;
    }
}
