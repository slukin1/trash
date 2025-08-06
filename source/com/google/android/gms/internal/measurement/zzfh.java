package com.google.android.gms.internal.measurement;

public final class zzfh extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzfh zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzfh zzfh = new zzfh();
        zza = zzfh;
        zzlb.zzbO(zzfh.class, zzfh);
    }

    private zzfh() {
    }

    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzlb.zzbL(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zzfh();
        } else {
            if (i12 == 4) {
                return new zzfg((zzez) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zza;
        }
    }
}
