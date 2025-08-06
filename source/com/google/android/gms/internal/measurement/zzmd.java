package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class zzmd {
    public static final int zza(int i11, Object obj, Object obj2) {
        zzmc zzmc = (zzmc) obj;
        zzmb zzmb = (zzmb) obj2;
        if (zzmc.isEmpty()) {
            return 0;
        }
        Iterator it2 = zzmc.entrySet().iterator();
        if (!it2.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it2.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzmc zzmc = (zzmc) obj;
        zzmc zzmc2 = (zzmc) obj2;
        if (!zzmc2.isEmpty()) {
            if (!zzmc.zze()) {
                zzmc = zzmc.zzb();
            }
            zzmc.zzd(zzmc2);
        }
        return zzmc;
    }
}
