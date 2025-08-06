package com.google.android.gms.internal.common;

import java.io.IOException;
import java.util.Iterator;

final class zzv implements Iterable {
    public final /* synthetic */ CharSequence zza;
    public final /* synthetic */ zzx zzb;

    public zzv(zzx zzx, CharSequence charSequence) {
        this.zzb = zzx;
        this.zza = charSequence;
    }

    public final Iterator iterator() {
        return this.zzb.zzh(this.zza);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        Iterator it2 = iterator();
        try {
            if (it2.hasNext()) {
                sb2.append(zzq.zza(it2.next(), ", "));
                while (it2.hasNext()) {
                    sb2.append(", ");
                    sb2.append(zzq.zza(it2.next(), ", "));
                }
            }
            sb2.append(']');
            return sb2.toString();
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }
}
