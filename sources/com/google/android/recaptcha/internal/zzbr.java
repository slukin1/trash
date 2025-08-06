package com.google.android.recaptcha.internal;

public final class zzbr {
    public static final zzbr zza = new zzbr();

    private zzbr() {
    }

    public static final zzp zza(int i11) {
        if (i11 == 403) {
            return new zzp(zzn.zzl, zzl.zzV, (String) null);
        }
        if (i11 == 404) {
            return new zzp(zzn.zze, zzl.zzs, (String) null);
        }
        if (i11 != 503) {
            return new zzp(zzn.zzc, zzl.zzW, (String) null);
        }
        return new zzp(zzn.zzl, zzl.zzV, (String) null);
    }
}
