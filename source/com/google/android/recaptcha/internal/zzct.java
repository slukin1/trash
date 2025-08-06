package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzct implements zzdd {
    public static final zzct zza = new zzct();

    private zzct() {
    }

    private static final boolean zzb(List list) {
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(Boolean.valueOf(((zzpq) it2.next()).zzN()));
        }
        return !arrayList.contains(Boolean.FALSE);
    }

    public final void zza(int i11, zzcj zzcj, zzpq... zzpqArr) throws zzae {
        if (zzb(ArraysKt___ArraysKt.x0(zzpqArr))) {
            for (zzpq zzi : zzpqArr) {
                zzcj.zzc().zzb(zzi.zzi());
            }
            return;
        }
        throw new zzae(4, 5, (Throwable) null);
    }
}
