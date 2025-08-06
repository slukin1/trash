package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzas implements Iterator {
    public final /* synthetic */ zzat zza;
    private int zzb = 0;

    public zzas(zzat zzat) {
        this.zza = zzat;
    }

    public final boolean hasNext() {
        return this.zzb < this.zza.zza.length();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        int i11 = this.zzb;
        zzat zzat = this.zza;
        if (i11 < zzat.zza.length()) {
            String zzb2 = zzat.zza;
            this.zzb = i11 + 1;
            return new zzat(String.valueOf(zzb2.charAt(i11)));
        }
        throw new NoSuchElementException();
    }
}
