package com.google.android.recaptcha.internal;

import java.util.List;

public final class zzpf extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzpf zzb;
    private zzjb zzd = zzit.zzx();

    static {
        zzpf zzpf = new zzpf();
        zzb = zzpf;
        zzit.zzD(zzpf.class, zzpf);
    }

    private zzpf() {
    }

    public static zzpf zzg(byte[] bArr) throws zzje {
        return (zzpf) zzit.zzu(zzb, bArr);
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzit.zzA(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzpr.class});
        } else if (i12 == 3) {
            return new zzpf();
        } else {
            if (i12 == 4) {
                return new zzpe((zzor) null);
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
