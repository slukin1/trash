package com.google.android.recaptcha.internal;

final class zzid {
    private final Object zza;
    private final int zzb;

    public zzid(Object obj, int i11) {
        this.zza = obj;
        this.zzb = i11;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzid)) {
            return false;
        }
        zzid zzid = (zzid) obj;
        if (this.zza == zzid.zza && this.zzb == zzid.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
