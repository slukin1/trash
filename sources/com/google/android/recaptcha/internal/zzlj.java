package com.google.android.recaptcha.internal;

public final class zzlj extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzlj zzb;
    /* access modifiers changed from: private */
    public long zzd;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzlj zzlj = new zzlj();
        zzb = zzlj;
        zzit.zzD(zzlj.class, zzlj);
    }

    private zzlj() {
    }

    public static zzli zzi() {
        return (zzli) zzb.zzp();
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
            return new zzlj();
        } else {
            if (i12 == 4) {
                return new zzli((zzlh) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
