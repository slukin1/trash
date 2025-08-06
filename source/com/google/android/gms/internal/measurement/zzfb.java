package com.google.android.gms.internal.measurement;

public final class zzfb extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzfb zza;
    private int zzd;
    private String zze = "";
    private zzli zzf = zzlb.zzbH();
    private boolean zzg;

    static {
        zzfb zzfb = new zzfb();
        zza = zzfb;
        zzlb.zzbO(zzfb.class, zzfb);
    }

    private zzfb() {
    }

    public final String zzb() {
        return this.zze;
    }

    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzlb.zzbL(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zzd", "zze", "zzf", zzfh.class, "zzg"});
        } else if (i12 == 3) {
            return new zzfb();
        } else {
            if (i12 == 4) {
                return new zzfa((zzez) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zza;
        }
    }
}
