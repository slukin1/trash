package com.google.android.recaptcha.internal;

import java.io.Serializable;
import java.util.ArrayList;

public final class zzdw implements zzdd {
    public static final zzdw zza = new zzdw();

    private zzdw() {
    }

    public final void zza(int i11, zzcj zzcj, zzpq... zzpqArr) throws zzae {
        Object obj;
        if (zzpqArr.length == 2) {
            Object zza2 = zzcj.zzc().zza(zzpqArr[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 != null) {
                Object zza3 = zzcj.zzc().zza(zzpqArr[1]);
                if (true != (zza3 instanceof Integer)) {
                    zza3 = null;
                }
                Integer num = (Integer) zza3;
                if (num != null) {
                    int intValue = num.intValue();
                    if (zza2 instanceof Integer) {
                        obj = Integer.valueOf(((Number) zza2).intValue() - intValue);
                    } else if (zza2 instanceof int[]) {
                        ArrayList arrayList = new ArrayList(r1);
                        for (int i12 : (int[]) zza2) {
                            arrayList.add(Integer.valueOf(i12 - intValue));
                        }
                        obj = (Serializable) arrayList.toArray(new Integer[0]);
                    } else {
                        throw new zzae(4, 5, (Throwable) null);
                    }
                    zzcj.zzc().zzf(i11, obj);
                    return;
                }
                throw new zzae(4, 5, (Throwable) null);
            }
            throw new zzae(4, 5, (Throwable) null);
        }
        throw new zzae(4, 3, (Throwable) null);
    }
}
