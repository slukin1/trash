package com.google.android.gms.internal.measurement;

import java.util.Iterator;

final class zzno implements Iterator {
    public final Iterator zza;
    public final /* synthetic */ zznp zzb;

    public zzno(zznp zznp) {
        this.zzb = zznp;
        this.zza = zznp.zza.iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
