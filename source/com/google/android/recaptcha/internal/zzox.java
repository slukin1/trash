package com.google.android.recaptcha.internal;

public final class zzox extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzox zzb;
    private int zzd;

    static {
        zzox zzox = new zzox();
        zzb = zzox;
        zzit.zzD(zzox.class, zzox);
    }

    private zzox() {
    }

    public static zzox zzg(byte[] bArr) throws zzje {
        return (zzox) zzit.zzu(zzb, bArr);
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzit.zzA(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"zzd"});
        } else if (i12 == 3) {
            return new zzox();
        } else {
            if (i12 == 4) {
                return new zzow((zzor) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzpb zzi() {
        zzpb zzb2 = zzpb.zzb(this.zzd);
        return zzb2 == null ? zzpb.UNRECOGNIZED : zzb2;
    }
}
