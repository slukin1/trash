package com.google.android.recaptcha.internal;

public final class zzdr implements zzdd {
    public static final zzdr zza = new zzdr();

    private zzdr() {
    }

    public final void zza(int i11, zzcj zzcj, zzpq... zzpqArr) throws zzae {
        if (zzpqArr.length == 1) {
            zzcj.zzc().zzf(i11, zzcj.zzc().zza(zzpqArr[0]));
            return;
        }
        throw new zzae(4, 3, (Throwable) null);
    }
}
