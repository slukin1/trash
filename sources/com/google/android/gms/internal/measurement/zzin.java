package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Objects;

final class zzin implements Serializable, zzim {
    public final zzim zza;
    public volatile transient boolean zzb;
    public transient Object zzc;

    public zzin(zzim zzim) {
        Objects.requireNonNull(zzim);
        this.zza = zzim;
    }

    public final String toString() {
        Object obj;
        if (this.zzb) {
            obj = "<supplier that returned " + String.valueOf(this.zzc) + ">";
        } else {
            obj = this.zza;
        }
        return "Suppliers.memoize(" + obj.toString() + ")";
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
