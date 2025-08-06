package com.google.android.recaptcha.internal;

public final class zzib extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzib zzb;
    /* access modifiers changed from: private */
    public long zzd;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzib zzib = new zzib();
        zzb = zzib;
        zzit.zzD(zzib.class, zzib);
    }

    private zzib() {
    }

    public static zzia zzi() {
        return (zzia) zzb.zzp();
    }

    public final int zzf() {
        return this.zze;
    }

    public final long zzg() {
        return this.zzd;
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return new zzkp(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzd", "zze"});
        } else if (i12 == 3) {
            return new zzib();
        } else {
            if (i12 == 4) {
                return new zzia((zzhz) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
