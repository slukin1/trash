package com.google.android.gms.internal.measurement;

final class zzkm {
    private final Object zza;
    private final int zzb;

    public zzkm(Object obj, int i11) {
        this.zza = obj;
        this.zzb = i11;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzkm)) {
            return false;
        }
        zzkm zzkm = (zzkm) obj;
        if (this.zza == zzkm.zza && this.zzb == zzkm.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
