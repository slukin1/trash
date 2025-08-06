package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Objects;

final class zzjg extends zzjb {
    public final transient Object zza;

    public zzjg(Object obj) {
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
        return new zzjc(this.zza);
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

    public final zzjh zzd() {
        return new zzjc(this.zza);
    }
}
