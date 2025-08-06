package com.google.android.recaptcha.internal;

public final class zzae extends Exception {
    private final Throwable zza;
    private final zzpg zzb;
    private final int zzc;
    private final int zzd;

    public zzae(int i11, int i12, Throwable th2) {
        this.zzc = i11;
        this.zzd = i12;
        this.zza = th2;
        zzpg zzf = zzph.zzf();
        zzf.zze(i12);
        zzf.zzp(i11);
        this.zzb = zzf;
    }

    public final Throwable getCause() {
        return this.zza;
    }

    public final zzpg zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzd;
    }
}
