package com.google.android.gms.internal.auth;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzhd extends AbstractList implements RandomAccess, zzfe {
    /* access modifiers changed from: private */
    public final zzfe zza;

    public zzhd(zzfe zzfe) {
        this.zza = zzfe;
    }

    public final /* bridge */ /* synthetic */ Object get(int i11) {
        return ((zzfd) this.zza).get(i11);
    }

    public final Iterator iterator() {
        return new zzhc(this);
    }

    public final ListIterator listIterator(int i11) {
        return new zzhb(this, i11);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzfe zze() {
        return this;
    }

    public final List zzg() {
        return this.zza.zzg();
    }
}
