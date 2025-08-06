package com.google.android.gms.internal.fido;

import java.util.NoSuchElementException;

final class zzav extends zzaz {
    public boolean zza;
    public final /* synthetic */ Object zzb;

    public zzav(Object obj) {
        this.zzb = obj;
    }

    public final boolean hasNext() {
        return !this.zza;
    }

    public final Object next() {
        if (!this.zza) {
            this.zza = true;
            return this.zzb;
        }
        throw new NoSuchElementException();
    }
}
