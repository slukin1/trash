package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgt extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzgt zza;
    private int zzd;
    private zzli zze = zzlb.zzbH();
    private zzgp zzf;

    static {
        zzgt zzgt = new zzgt();
        zza = zzgt;
        zzlb.zzbO(zzgt.class, zzgt);
    }

    private zzgt() {
    }

    public final zzgp zza() {
        zzgp zzgp = this.zzf;
        return zzgp == null ? zzgp.zzc() : zzgp;
    }

    public final List zzc() {
        return this.zze;
    }

    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzlb.zzbL(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzd", "zze", zzgy.class, "zzf"});
        } else if (i12 == 3) {
            return new zzgt();
        } else {
            if (i12 == 4) {
                return new zzgs((zzgn) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zza;
        }
    }
}
