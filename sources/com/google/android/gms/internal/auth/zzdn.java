package com.google.android.gms.internal.auth;

import java.io.Serializable;

public final class zzdn {
    public static zzdj zza(zzdj zzdj) {
        if ((zzdj instanceof zzdl) || (zzdj instanceof zzdk)) {
            return zzdj;
        }
        if (zzdj instanceof Serializable) {
            return new zzdk(zzdj);
        }
        return new zzdl(zzdj);
    }

    public static zzdj zzb(Object obj) {
        return new zzdm(obj);
    }
}
