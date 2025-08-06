package com.google.android.recaptcha.internal;

import java.util.Arrays;
import kotlin.jvm.internal.x;

public final class zzdi implements zzdd {
    public static final zzdi zza = new zzdi();

    private zzdi() {
    }

    public final void zza(int i11, zzcj zzcj, zzpq... zzpqArr) throws zzae {
        Class<?> cls;
        int length = zzpqArr.length;
        if (length >= 2) {
            Object zza2 = zzcj.zzc().zza(zzpqArr[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 != null) {
                if (zza2 instanceof Class) {
                    cls = (Class) zza2;
                } else {
                    cls = zza2.getClass();
                }
                Object zza3 = zzcj.zzc().zza(zzpqArr[1]);
                if (true != (zza3 instanceof String)) {
                    zza3 = null;
                }
                String str = (String) zza3;
                if (str != null) {
                    String zza4 = zzcj.zzh().zza(str);
                    if (!x.b(zza4, "forName")) {
                        Class[] zzg = zzcj.zzc().zzg(ArraysKt___ArraysKt.x0(zzpqArr).subList(2, length));
                        try {
                            zzcj.zzc().zzf(i11, cls.getMethod(zza4, (Class[]) Arrays.copyOf(zzg, zzg.length)));
                        } catch (Exception e11) {
                            throw new zzae(6, 13, e11);
                        }
                    } else {
                        throw new zzae(6, 48, (Throwable) null);
                    }
                } else {
                    throw new zzae(4, 5, (Throwable) null);
                }
            } else {
                throw new zzae(4, 5, (Throwable) null);
            }
        } else {
            throw new zzae(4, 3, (Throwable) null);
        }
    }
}
