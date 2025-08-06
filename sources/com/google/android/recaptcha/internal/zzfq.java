package com.google.android.recaptcha.internal;

import java.util.Iterator;

final class zzfq implements Iterator {
    public boolean zza = true;
    public final /* synthetic */ Iterator zzb;

    public zzfq(zzfr zzfr, Iterator it2) {
        this.zzb = it2;
    }

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final Object next() {
        Object next = this.zzb.next();
        this.zza = false;
        return next;
    }

    public final void remove() {
        zzff.zze(!this.zza, "no calls to next() since the last call to remove()");
        this.zzb.remove();
    }
}
