package com.google.android.recaptcha.internal;

import java.lang.reflect.Field;

public final class zzdu implements zzdd {
    public static final zzdu zza = new zzdu();

    private zzdu() {
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
                    field.set((Object) null, zzcj.zzc().zza(zzpqArr[1]));
                } catch (Exception e11) {
                    throw new zzae(6, 11, e11);
                }
            } else {
                throw new zzae(4, 5, (Throwable) null);
            }
        } else {
            throw new zzae(4, 3, (Throwable) null);
        }
    }
}
