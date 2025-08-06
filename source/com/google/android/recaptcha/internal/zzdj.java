package com.google.android.recaptcha.internal;

import java.lang.reflect.Field;

public final class zzdj implements zzdd {
    public static final zzdj zza = new zzdj();

    private zzdj() {
    }

    public final void zza(int i11, zzcj zzcj, zzpq... zzpqArr) throws zzae {
        if (zzpqArr.length == 2) {
            Object zza2 = zzcj.zzc().zza(zzpqArr[0]);
            if (true != (zza2 instanceof Field)) {
                zza2 = null;
            }
            Field field = (Field) zza2;
            if (field != null) {
                try {
                    zzcj.zzc().zzf(i11, field.get(zzcj.zzc().zza(zzpqArr[1])));
                } catch (Exception e11) {
                    throw new zzae(6, 16, e11);
                }
            } else {
                throw new zzae(4, 5, (Throwable) null);
            }
        } else {
            throw new zzae(4, 3, (Throwable) null);
        }
    }
}
