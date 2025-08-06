package com.google.android.gms.internal.measurement;

final class zzlz implements zzmg {
    private final zzmg[] zza;

    public zzlz(zzmg... zzmgArr) {
        this.zza = zzmgArr;
    }

    public final zzmf zzb(Class cls) {
        zzmg[] zzmgArr = this.zza;
        for (int i11 = 0; i11 < 2; i11++) {
            zzmg zzmg = zzmgArr[i11];
            if (zzmg.zzc(cls)) {
                return zzmg.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean zzc(Class cls) {
        zzmg[] zzmgArr = this.zza;
        for (int i11 = 0; i11 < 2; i11++) {
            if (zzmgArr[i11].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
