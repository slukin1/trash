package com.google.android.gms.internal.measurement;

import java.util.Iterator;

final class zzak implements Iterator {
    public final /* synthetic */ Iterator zza;

    public zzak(Iterator it2) {
        this.zza = it2;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return new zzat((String) this.zza.next());
    }
}
