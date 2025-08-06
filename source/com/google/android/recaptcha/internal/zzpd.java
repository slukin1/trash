package com.google.android.recaptcha.internal;

public final class zzpd extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzpd zzb;
    private int zzd = 0;
    private Object zze;

    static {
        zzpd zzpd = new zzpd();
        zzb = zzpd;
        zzit.zzD(zzpd.class, zzpd);
    }

    private zzpd() {
    }

    public static /* synthetic */ void zzH(zzpd zzpd, zznf zznf) {
        zznf.getClass();
        zzpd.zze = zznf;
        zzpd.zzd = 1;
    }

    public static /* synthetic */ void zzI(zzpd zzpd, zznu zznu) {
        zznu.getClass();
        zzpd.zze = zznu;
        zzpd.zzd = 2;
    }

    public static zzpc zzi() {
        return (zzpc) zzb.zzp();
    }

    public static zzpd zzk(byte[] bArr) throws zzje {
        return (zzpd) zzit.zzu(zzb, bArr);
    }

    public final int zzJ() {
        int i11 = this.zzd;
        if (i11 == 0) {
            return 3;
        }
        int i12 = 1;
        if (i11 != 1) {
            i12 = 2;
            if (i11 != 2) {
                return 0;
            }
        }
        return i12;
    }

    public final zznf zzf() {
        if (this.zzd == 1) {
            return (zznf) this.zze;
        }
        return zznf.zzH();
    }

    public final zznu zzg() {
        if (this.zzd == 2) {
            return (zznu) this.zze;
        }
        return zznu.zzg();
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzit.zzA(zzb, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"zze", "zzd", zznf.class, zznu.class});
        } else if (i12 == 3) {
            return new zzpd();
        } else {
            if (i12 == 4) {
                return new zzpc((zzor) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
