package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgr extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzgr zza;
    private int zzd;
    private String zze = "";
    private zzli zzf = zzlb.zzbH();

    static {
        zzgr zzgr = new zzgr();
        zza = zzgr;
        zzlb.zzbO(zzgr.class, zzgr);
    }

    private zzgr() {
    }

    public final String zzb() {
        return this.zze;
    }

    public final List zzc() {
        return this.zzf;
    }

    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzlb.zzbL(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzd", "zze", "zzf", zzgy.class});
        } else if (i12 == 3) {
            return new zzgr();
        } else {
            if (i12 == 4) {
                return new zzgq((zzgn) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zza;
        }
    }
}
