package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

final class zzjr extends zzjt {
    public final /* synthetic */ zzka zza;
    private int zzb = 0;
    private final int zzc;

    public zzjr(zzka zzka) {
        this.zza = zzka;
        this.zzc = zzka.zzd();
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i11 = this.zzb;
        if (i11 < this.zzc) {
            this.zzb = i11 + 1;
            return this.zza.zzb(i11);
        }
        throw new NoSuchElementException();
    }
}
