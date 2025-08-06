package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzad implements Iterator {
    public final /* synthetic */ zzae zza;
    private int zzb = 0;

    public zzad(zzae zzae) {
        this.zza = zzae;
    }

    public final boolean hasNext() {
        return this.zzb < this.zza.zzc();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        if (this.zzb < this.zza.zzc()) {
            zzae zzae = this.zza;
            int i11 = this.zzb;
            this.zzb = i11 + 1;
            return zzae.zze(i11);
        }
        int i12 = this.zzb;
        throw new NoSuchElementException("Out of bounds index: " + i12);
    }
}
