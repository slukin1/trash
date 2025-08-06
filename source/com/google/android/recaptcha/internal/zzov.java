package com.google.android.recaptcha.internal;

public final class zzov extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzov zzb;
    private String zzd = "";
    private String zze = "";

    static {
        zzov zzov = new zzov();
        zzb = zzov;
        zzit.zzD(zzov.class, zzov);
    }

    private zzov() {
    }

    public static zzou zzf() {
        return (zzou) zzb.zzp();
    }

    public static /* synthetic */ void zzi(zzov zzov, String str) {
        str.getClass();
        zzov.zzd = str;
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzit.zzA(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"zzd", "zze"});
        } else if (i12 == 3) {
            return new zzov();
        } else {
            if (i12 == 4) {
                return new zzou((zzor) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
