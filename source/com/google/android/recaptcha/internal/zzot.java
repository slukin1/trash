package com.google.android.recaptcha.internal;

public final class zzot extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzot zzb;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";

    static {
        zzot zzot = new zzot();
        zzb = zzot;
        zzit.zzD(zzot.class, zzot);
    }

    private zzot() {
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzit.zzA(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zzot();
        } else {
            if (i12 == 4) {
                return new zzos((zzor) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
