package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.Arrays;

public final class zzdl implements zzdd {
    public static final zzdl zza = new zzdl();

    private zzdl() {
    }

    public final void zza(int i11, zzcj zzcj, zzpq... zzpqArr) throws zzae {
        int length = zzpqArr.length;
        if (length >= 2) {
            Object zza2 = zzcj.zzc().zza(zzpqArr[0]);
            if (true != (zza2 instanceof Method)) {
                zza2 = null;
            }
            Method method = (Method) zza2;
            if (method != null) {
                Object zza3 = zzcj.zzc().zza(zzpqArr[1]);
                Object[] zzh = zzcj.zzc().zzh(ArraysKt___ArraysKt.x0(zzpqArr).subList(2, length));
                try {
                    zzcj.zzc().zzf(i11, method.invoke(zza3, Arrays.copyOf(zzh, zzh.length)));
                } catch (Exception e11) {
                    throw new zzae(6, 15, e11);
                }
            } else {
                throw new zzae(4, 5, (Throwable) null);
            }
        } else {
            throw new zzae(4, 3, (Throwable) null);
        }
    }
}
