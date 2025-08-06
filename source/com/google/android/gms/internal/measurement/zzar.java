package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzar implements Iterator {
    public final /* synthetic */ zzat zza;
    private int zzb = 0;

    public zzar(zzat zzat) {
        this.zza = zzat;
    }

    public final boolean hasNext() {
        return this.zzb < this.zza.zza.length();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        int i11 = this.zzb;
        if (i11 < this.zza.zza.length()) {
            this.zzb = i11 + 1;
            return new zzat(String.valueOf(i11));
        }
        throw new NoSuchElementException();
    }
}
