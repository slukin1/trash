package com.google.android.gms.internal.auth;

final class zzfn implements zzfu {
    private final zzfu[] zza;

    public zzfn(zzfu... zzfuArr) {
        this.zza = zzfuArr;
    }

    public final zzft zzb(Class cls) {
        zzfu[] zzfuArr = this.zza;
        for (int i11 = 0; i11 < 2; i11++) {
            zzfu zzfu = zzfuArr[i11];
            if (zzfu.zzc(cls)) {
                return zzfu.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean zzc(Class cls) {
        zzfu[] zzfuArr = this.zza;
        for (int i11 = 0; i11 < 2; i11++) {
            if (zzfuArr[i11].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
