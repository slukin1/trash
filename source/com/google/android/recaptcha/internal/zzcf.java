package com.google.android.recaptcha.internal;

import d10.p;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.x;

public final class zzcf extends zzce {
    private final p zza;
    private final String zzb;

    public zzcf(p pVar, String str, Object obj) {
        super(obj);
        this.zza = pVar;
        this.zzb = str;
    }

    public final boolean zza(Object obj, Method method, Object[] objArr) {
        List list;
        if (!x.b(method.getName(), this.zzb)) {
            return false;
        }
        zzpi zzf = zzpl.zzf();
        if (objArr != null) {
            list = new ArrayList(objArr.length);
            for (Object obj2 : objArr) {
                zzpj zzf2 = zzpk.zzf();
                zzf2.zzv(obj2.toString());
                list.add((zzpk) zzf2.zzj());
            }
        } else {
            list = CollectionsKt__CollectionsKt.k();
        }
        zzf.zzd(list);
        p pVar = this.zza;
        byte[] zzd = ((zzpl) zzf.zzj()).zzd();
        pVar.invoke(objArr, zzfy.zzh().zzi(zzd, 0, zzd.length));
        return true;
    }
}
