package com.google.android.recaptcha.internal;

import java.util.List;

public final class zznx extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zznx zzb;
    private zzjb zzd = zzit.zzx();

    static {
        zznx zznx = new zznx();
        zzb = zznx;
        zzit.zzD(zznx.class, zznx);
    }

    private zznx() {
    }

    public static zznx zzg() {
        return zzb;
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzit.zzA(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"zzd"});
        } else if (i12 == 3) {
            return new zznx();
        } else {
            if (i12 == 4) {
                return new zznw((zznv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final List zzi() {
        return this.zzd;
    }
}
