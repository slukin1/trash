package com.google.android.recaptcha.internal;

public final class zzhw extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzhw zzb;
    private int zzd;
    private String zze = "";
    private boolean zzf;
    private byte zzg = 2;

    static {
        zzhw zzhw = new zzhw();
        zzb = zzhw;
        zzit.zzD(zzhw.class, zzhw);
    }

    private zzhw() {
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzg);
        }
        byte b11 = 1;
        if (i12 == 2) {
            return new zzkp(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zzhw();
        } else {
            if (i12 == 4) {
                return new zzhv((zzhj) null);
            }
            if (i12 == 5) {
                return zzb;
            }
            if (obj == null) {
                b11 = 0;
            }
            this.zzg = b11;
            return null;
        }
    }
}
