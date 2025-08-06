package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgk extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzgk zza;
    private int zzd;
    private int zze;
    private zzlh zzf = zzlb.zzbF();

    static {
        zzgk zzgk = new zzgk();
        zza = zzgk;
        zzlb.zzbO(zzgk.class, zzgk);
    }

    private zzgk() {
    }

    public static zzgj zzd() {
        return (zzgj) zza.zzbA();
    }

    public static /* synthetic */ void zzg(zzgk zzgk, int i11) {
        zzgk.zzd |= 1;
        zzgk.zze = i11;
    }

    public static /* synthetic */ void zzh(zzgk zzgk, Iterable iterable) {
        zzlh zzlh = zzgk.zzf;
        if (!zzlh.zzc()) {
            zzgk.zzf = zzlb.zzbG(zzlh);
        }
        zzjk.zzbw(iterable, zzgk.zzf);
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final int zzb() {
        return this.zze;
    }

    public final long zzc(int i11) {
        return this.zzf.zza(i11);
    }

    public final List zzf() {
        return this.zzf;
    }

    public final boolean zzi() {
        return (this.zzd & 1) != 0;
    }

    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzlb.zzbL(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zzgk();
        } else {
            if (i12 == 4) {
                return new zzgj((zzfk) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zza;
        }
    }
}
