package com.google.android.recaptcha.internal;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public final class zzdp implements zzdd {
    public static final zzdp zza = new zzdp();

    private zzdp() {
    }

    public final void zza(int i11, zzcj zzcj, zzpq... zzpqArr) throws zzae {
        Constructor<?> constructor;
        int length = zzpqArr.length;
        if (length != 0) {
            Object zza2 = zzcj.zzc().zza(zzpqArr[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 != null) {
                if (zza2 instanceof Constructor) {
                    constructor = (Constructor) zza2;
                } else {
                    constructor = zza2.getClass().getConstructor(new Class[0]);
                }
                Object[] zzh = zzcj.zzc().zzh(ArraysKt___ArraysKt.x0(zzpqArr).subList(1, length));
                try {
                    zzcj.zzc().zzf(i11, constructor.newInstance(Arrays.copyOf(zzh, zzh.length)));
                } catch (Exception e11) {
                    throw new zzae(6, 14, e11);
                }
            } else {
                throw new zzae(4, 5, (Throwable) null);
            }
        } else {
            throw new zzae(4, 3, (Throwable) null);
        }
    }
}
