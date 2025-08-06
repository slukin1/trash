package com.google.android.recaptcha.internal;

public final class zzdh implements zzdd {
    public static final zzdh zza = new zzdh();

    private zzdh() {
    }

    public final void zza(int i11, zzcj zzcj, zzpq... zzpqArr) throws zzae {
        Class<?> cls;
        if (zzpqArr.length == 2) {
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
                    try {
                        zzcj.zzc().zzf(i11, cls.getField(zzcj.zzh().zza(str)));
                    } catch (Exception e11) {
                        throw new zzae(6, 10, e11);
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
