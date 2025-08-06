package com.google.android.gms.internal.auth;

import java.io.Serializable;
import java.util.Objects;

final class zzdk implements Serializable, zzdj {
    public final zzdj zza;
    public volatile transient boolean zzb;
    public transient Object zzc;

    public zzdk(zzdj zzdj) {
        Objects.requireNonNull(zzdj);
        this.zza = zzdj;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Suppliers.memoize(");
        if (this.zzb) {
            obj = "<supplier that returned " + this.zzc + ">";
        } else {
            obj = this.zza;
        }
        sb2.append(obj);
        sb2.append(")");
        return sb2.toString();
    }

    public final Object zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    Object zza2 = this.zza.zza();
                    this.zzc = zza2;
                    this.zzb = true;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
