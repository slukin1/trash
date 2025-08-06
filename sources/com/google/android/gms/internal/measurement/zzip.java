package com.google.android.gms.internal.measurement;

import java.util.Objects;

final class zzip implements zzim {
    private static final zzim zza = zzio.zza;
    private volatile zzim zzb;
    private Object zzc;

    public zzip(zzim zzim) {
        Objects.requireNonNull(zzim);
        this.zzb = zzim;
    }

    public final String toString() {
        Object obj = this.zzb;
        if (obj == zza) {
            obj = "<supplier that returned " + String.valueOf(this.zzc) + ">";
        }
        return "Suppliers.memoize(" + String.valueOf(obj) + ")";
    }

    public final Object zza() {
        zzim zzim = this.zzb;
        zzim zzim2 = zza;
        if (zzim != zzim2) {
            synchronized (this) {
                if (this.zzb != zzim2) {
                    Object zza2 = this.zzb.zza();
                    this.zzc = zza2;
                    this.zzb = zzim2;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
