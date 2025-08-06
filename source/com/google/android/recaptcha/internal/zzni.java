package com.google.android.recaptcha.internal;

import java.util.List;

public final class zzni extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzni zzb;
    private zzjb zzd = zzit.zzx();
    private zzjb zze = zzit.zzx();

    static {
        zzni zzni = new zzni();
        zzb = zzni;
        zzit.zzD(zzni.class, zzni);
    }

    private zzni() {
    }

    public static /* synthetic */ void zzI(zzni zzni, zznf zznf) {
        zznf.getClass();
        zzjb zzjb = zzni.zzd;
        if (!zzjb.zzc()) {
            zzni.zzd = zzit.zzy(zzjb);
        }
        zzni.zzd.add(zznf);
    }

    public static /* synthetic */ void zzJ(zzni zzni, zznu zznu) {
        zznu.getClass();
        zzjb zzjb = zzni.zze;
        if (!zzjb.zzc()) {
            zzni.zze = zzit.zzy(zzjb);
        }
        zzni.zze.add(zznu);
    }

    public static zznh zzi() {
        return (zznh) zzb.zzp();
    }

    public static zzni zzk(byte[] bArr) throws zzje {
        return (zzni) zzit.zzu(zzb, bArr);
    }

    public final List zzH() {
        return this.zzd;
    }

    public final int zzf() {
        return this.zzd.size();
    }

    public final int zzg() {
        return this.zze.size();
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzit.zzA(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"zzd", zznf.class, "zze", zznu.class});
        } else if (i12 == 3) {
            return new zzni();
        } else {
            if (i12 == 4) {
                return new zznh((zzng) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
