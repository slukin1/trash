package com.google.android.recaptcha.internal;

final class zzjv implements zzkc {
    private final zzkc[] zza;

    public zzjv(zzkc... zzkcArr) {
        this.zza = zzkcArr;
    }

    public final zzkb zzb(Class cls) {
        for (int i11 = 0; i11 < 2; i11++) {
            zzkc zzkc = this.zza[i11];
            if (zzkc.zzc(cls)) {
                return zzkc.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean zzc(Class cls) {
        for (int i11 = 0; i11 < 2; i11++) {
            if (this.zza[i11].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
