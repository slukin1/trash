package com.google.android.recaptcha.internal;

public final class zzmx extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzmx zzb;
    private String zzd = "";
    private String zze = "";

    static {
        zzmx zzmx = new zzmx();
        zzb = zzmx;
        zzit.zzD(zzmx.class, zzmx);
    }

    private zzmx() {
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzit.zzA(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"zzd", "zze"});
        } else if (i12 == 3) {
            return new zzmx();
        } else {
            if (i12 == 4) {
                return new zzmw((zzmv) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
