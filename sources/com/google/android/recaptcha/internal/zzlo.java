package com.google.android.recaptcha.internal;

import java.util.ListIterator;

final class zzlo implements ListIterator {
    public final ListIterator zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ zzlq zzc;

    public zzlo(zzlq zzlq, int i11) {
        this.zzc = zzlq;
        this.zzb = i11;
        this.zza = zzlq.zza.listIterator(i11);
    }

    public final /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zza.hasPrevious();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    public final int nextIndex() {
        return this.zza.nextIndex();
    }

    public final /* bridge */ /* synthetic */ Object previous() {
        return (String) this.zza.previous();
    }

    public final int previousIndex() {
        return this.zza.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }
}
