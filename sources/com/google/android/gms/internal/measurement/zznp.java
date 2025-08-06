package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
public final class zznp extends AbstractList implements RandomAccess, zzlq {
    /* access modifiers changed from: private */
    public final zzlq zza;

    public zznp(zzlq zzlq) {
        this.zza = zzlq;
    }

    public final /* bridge */ /* synthetic */ Object get(int i11) {
        return ((zzlp) this.zza).get(i11);
    }

    public final Iterator iterator() {
        return new zzno(this);
    }

    public final ListIterator listIterator(int i11) {
        return new zznn(this, i11);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzlq zze() {
        return this;
    }

    public final Object zzf(int i11) {
        return this.zza.zzf(i11);
    }

    public final List zzh() {
        return this.zza.zzh();
    }

    public final void zzi(zzka zzka) {
        throw new UnsupportedOperationException();
    }
}
