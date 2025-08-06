package com.google.android.recaptcha.internal;

public final class zzhl extends zzip {
    /* access modifiers changed from: private */
    public static final zzhl zzd;
    private int zze;
    private boolean zzf;
    private zzht zzg;
    private boolean zzh;
    private zzjb zzi = zzko.zze();
    private byte zzj = 2;

    static {
        zzhl zzhl = new zzhl();
        zzd = zzhl;
        zzit.zzD(zzhl.class, zzhl);
    }

    private zzhl() {
    }

    public static zzhl zzg() {
        return zzd;
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzj);
        }
        byte b11 = 1;
        if (i12 == 2) {
            return new zzkp(zzd, "\u0001\u0004\u0000\u0001\u0001ϧ\u0004\u0000\u0001\u0002\u0001ဇ\u0000\u0002ᐉ\u0001\u0003ဇ\u0002ϧЛ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzhx.class});
        } else if (i12 == 3) {
            return new zzhl();
        } else {
            if (i12 == 4) {
                return new zzhk((zzhj) null);
            }
            if (i12 == 5) {
                return zzd;
            }
            if (obj == null) {
                b11 = 0;
            }
            this.zzj = b11;
            return null;
        }
    }
}
