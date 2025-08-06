package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzek extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzek zza;
    private int zzd;
    private int zze;
    private String zzf = "";
    private zzli zzg = zzlb.zzbH();
    private boolean zzh;
    private zzer zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;

    static {
        zzek zzek = new zzek();
        zza = zzek;
        zzlb.zzbO(zzek.class, zzek);
    }

    private zzek() {
    }

    public static zzej zzc() {
        return (zzej) zza.zzbA();
    }

    public static /* synthetic */ void zzi(zzek zzek, String str) {
        zzek.zzd |= 2;
        zzek.zzf = str;
    }

    public static /* synthetic */ void zzj(zzek zzek, int i11, zzem zzem) {
        zzem.getClass();
        zzli zzli = zzek.zzg;
        if (!zzli.zzc()) {
            zzek.zzg = zzlb.zzbI(zzli);
        }
        zzek.zzg.set(i11, zzem);
    }

    public final int zza() {
        return this.zzg.size();
    }

    public final int zzb() {
        return this.zze;
    }

    public final zzem zze(int i11) {
        return (zzem) this.zzg.get(i11);
    }

    public final zzer zzf() {
        zzer zzer = this.zzi;
        return zzer == null ? zzer.zzb() : zzer;
    }

    public final String zzg() {
        return this.zzf;
    }

    public final List zzh() {
        return this.zzg;
    }

    public final boolean zzk() {
        return this.zzj;
    }

    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzlb.zzbL(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", zzem.class, "zzh", "zzi", "zzj", "zzk", "zzl"});
        } else if (i12 == 3) {
            return new zzek();
        } else {
            if (i12 == 4) {
                return new zzej((zzeg) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final boolean zzm() {
        return this.zzk;
    }

    public final boolean zzn() {
        return this.zzl;
    }

    public final boolean zzo() {
        return (this.zzd & 8) != 0;
    }

    public final boolean zzp() {
        return (this.zzd & 1) != 0;
    }

    public final boolean zzq() {
        return (this.zzd & 64) != 0;
    }
}
