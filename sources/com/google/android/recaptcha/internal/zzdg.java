package com.google.android.recaptcha.internal;

import java.util.Arrays;

public final class zzdg implements zzdd {
    public static final zzdg zza = new zzdg();

    private zzdg() {
    }

    public final void zza(int i11, zzcj zzcj, zzpq... zzpqArr) throws zzae {
        int length = zzpqArr.length;
        if (length != 0) {
            Object zza2 = zzcj.zzc().zza(zzpqArr[0]);
            if (true != (zza2 instanceof Class)) {
                zza2 = null;
            }
            Class cls = (Class) zza2;
            if (cls != null) {
                Class[] zzg = zzcj.zzc().zzg(ArraysKt___ArraysKt.x0(zzpqArr).subList(1, length));
                try {
                    zzcj.zzc().zzf(i11, cls.getConstructor((Class[]) Arrays.copyOf(zzg, zzg.length)));
                } catch (Exception e11) {
                    throw new zzae(6, 9, e11);
                }
            } else {
                throw new zzae(4, 5, (Throwable) null);
            }
        } else {
            throw new zzae(4, 3, (Throwable) null);
        }
    }
}
