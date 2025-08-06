package com.google.android.gms.measurement.internal;

import java.util.Iterator;

final class zzar implements Iterator {
    public final Iterator zza;
    public final /* synthetic */ zzas zzb;

    public zzar(zzas zzas) {
        this.zzb = zzas;
        this.zza = zzas.zza.keySet().iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    /* renamed from: zza */
    public final String next() {
        return (String) this.zza.next();
    }
}
