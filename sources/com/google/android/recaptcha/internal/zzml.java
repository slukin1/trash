package com.google.android.recaptcha.internal;

public final class zzml extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzml zzb;
    private int zzd;
    private zzib zze;
    private int zzf;

    static {
        zzml zzml = new zzml();
        zzb = zzml;
        zzit.zzD(zzml.class, zzml);
    }

    private zzml() {
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzit.zzA(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zzml();
        } else {
            if (i12 == 4) {
                return new zzmk((zzmj) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
