package com.google.android.gms.internal.fido;

import java.util.Iterator;
import java.util.Objects;

final class zzay extends zzau {
    public final transient Object zza;

    public zzay(Object obj) {
        Objects.requireNonNull(obj);
        this.zza = obj;
    }

    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzav(this.zza);
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "[" + obj + "]";
    }

    public final int zza(Object[] objArr, int i11) {
        objArr[0] = this.zza;
        return 1;
    }

    public final zzaz zzd() {
        return new zzav(this.zza);
    }
}
