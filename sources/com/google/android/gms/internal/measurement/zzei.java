package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzei extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzei zza;
    private int zzd;
    private int zze;
    private zzli zzf = zzlb.zzbH();
    private zzli zzg = zzlb.zzbH();
    private boolean zzh;
    private boolean zzi;

    static {
        zzei zzei = new zzei();
        zza = zzei;
        zzlb.zzbO(zzei.class, zzei);
    }

    private zzei() {
    }

    public static /* synthetic */ void zzi(zzei zzei, int i11, zzet zzet) {
        zzet.getClass();
        zzli zzli = zzei.zzf;
        if (!zzli.zzc()) {
            zzei.zzf = zzlb.zzbI(zzli);
        }
        zzei.zzf.set(i11, zzet);
    }

    public static /* synthetic */ void zzj(zzei zzei, int i11, zzek zzek) {
        zzek.getClass();
        zzli zzli = zzei.zzg;
        if (!zzli.zzc()) {
            zzei.zzg = zzlb.zzbI(zzli);
        }
        zzei.zzg.set(i11, zzek);
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzg.size();
    }

    public final int zzc() {
        return this.zzf.size();
    }

    public final zzek zze(int i11) {
        return (zzek) this.zzg.get(i11);
    }

    public final zzet zzf(int i11) {
        return (zzet) this.zzf.get(i11);
    }

    public final List zzg() {
        return this.zzg;
    }

    public final List zzh() {
        return this.zzf;
    }

    public final boolean zzk() {
        return (this.zzd & 1) != 0;
    }

    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzlb.zzbL(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzd", "zze", "zzf", zzet.class, "zzg", zzek.class, "zzh", "zzi"});
        } else if (i12 == 3) {
            return new zzei();
        } else {
            if (i12 == 4) {
                return new zzeh((zzeg) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zza;
        }
    }
}
