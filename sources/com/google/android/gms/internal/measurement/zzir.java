package com.google.android.gms.internal.measurement;

import java.io.Serializable;

public final class zzir {
    public static zzim zza(zzim zzim) {
        if ((zzim instanceof zzip) || (zzim instanceof zzin)) {
            return zzim;
        }
        if (zzim instanceof Serializable) {
            return new zzin(zzim);
        }
        return new zzip(zzim);
    }

    public static zzim zzb(Object obj) {
        return new zziq(obj);
    }
}
