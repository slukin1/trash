package com.google.android.recaptcha.internal;

public final class zzdf implements zzdd {
    public static final zzdf zza = new zzdf();

    private zzdf() {
    }

    public final void zza(int i11, zzcj zzcj, zzpq... zzpqArr) throws zzae {
        if (zzpqArr.length == 1) {
            Object zza2 = zzcj.zzc().zza(zzpqArr[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 != null) {
                try {
                    if (zza2 instanceof String) {
                        zza2 = zzcj.zzh().zza((String) zza2);
                    }
                    zzcj.zzc().zzf(i11, zzci.zza(zza2));
                } catch (zzae e11) {
                    throw e11;
                } catch (Exception e12) {
                    throw new zzae(6, 8, e12);
                }
            } else {
                throw new zzae(4, 5, (Throwable) null);
            }
        } else {
            throw new zzae(4, 3, (Throwable) null);
        }
    }
}
