package com.google.android.gms.internal.measurement;

public final class zzfz extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzfz zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private zzfn zzg;

    static {
        zzfz zzfz = new zzfz();
        zza = zzfz;
        zzlb.zzbO(zzfz.class, zzfz);
    }

    private zzfz() {
    }

    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzlb.zzbL(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i12 == 3) {
            return new zzfz();
        } else {
            if (i12 == 4) {
                return new zzfy((zzfk) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zza;
        }
    }
}
