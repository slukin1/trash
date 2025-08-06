package com.google.android.gms.internal.auth;

import java.util.Objects;

final class zzdl implements zzdj {
    public volatile zzdj zza;
    public volatile boolean zzb;
    public Object zzc;

    public zzdl(zzdj zzdj) {
        Objects.requireNonNull(zzdj);
        this.zza = zzdj;
    }

    public final String toString() {
        Object obj = this.zza;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Suppliers.memoize(");
        if (obj == null) {
            obj = "<supplier that returned " + this.zzc + ">";
        }
        sb2.append(obj);
        sb2.append(")");
        return sb2.toString();
    }

    public final Object zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    zzdj zzdj = this.zza;
                    zzdj.getClass();
                    Object zza2 = zzdj.zza();
                    this.zzc = zza2;
                    this.zzb = true;
                    this.zza = null;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
