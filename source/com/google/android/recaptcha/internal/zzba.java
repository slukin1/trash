package com.google.android.recaptcha.internal;

import kotlin.jvm.internal.x;

public final class zzba {
    private final String zza;
    private final long zzb;
    private final int zzc;

    public zzba(String str, long j11, int i11) {
        this.zza = str;
        this.zzb = j11;
        this.zzc = i11;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzba)) {
            return false;
        }
        zzba zzba = (zzba) obj;
        return x.b(zzba.zza, this.zza) && zzba.zzb == this.zzb && zzba.zzc == this.zzc;
    }

    public final int zza() {
        return this.zzc;
    }

    public final long zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zza;
    }
}
