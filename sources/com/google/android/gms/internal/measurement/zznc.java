package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class zznc implements Iterator {
    public final /* synthetic */ zzng zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    public /* synthetic */ zznc(zzng zzng, zznb zznb) {
        this.zza = zzng;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }

    public final boolean hasNext() {
        if (this.zzb + 1 < this.zza.zzb.size()) {
            return true;
        }
        if (!this.zza.zzc.isEmpty()) {
            return zza().hasNext();
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i11 = this.zzb + 1;
        this.zzb = i11;
        if (i11 < this.zza.zzb.size()) {
            return (Map.Entry) this.zza.zzb.get(this.zzb);
        }
        return (Map.Entry) zza().next();
    }

    public final void remove() {
        if (this.zzc) {
            this.zzc = false;
            this.zza.zzn();
            if (this.zzb < this.zza.zzb.size()) {
                zzng zzng = this.zza;
                int i11 = this.zzb;
                this.zzb = i11 - 1;
                Object unused = zzng.zzl(i11);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
