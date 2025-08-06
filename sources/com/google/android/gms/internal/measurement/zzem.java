package com.google.android.gms.internal.measurement;

public final class zzem extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzem zza;
    private int zzd;
    private zzey zze;
    private zzer zzf;
    private boolean zzg;
    private String zzh = "";

    static {
        zzem zzem = new zzem();
        zza = zzem;
        zzlb.zzbO(zzem.class, zzem);
    }

    private zzem() {
    }

    public static zzem zzb() {
        return zza;
    }

    public static /* synthetic */ void zzf(zzem zzem, String str) {
        zzem.zzd |= 8;
        zzem.zzh = str;
    }

    public final zzer zzc() {
        zzer zzer = this.zzf;
        return zzer == null ? zzer.zzb() : zzer;
    }

    public final zzey zzd() {
        zzey zzey = this.zze;
        return zzey == null ? zzey.zzc() : zzey;
    }

    public final String zze() {
        return this.zzh;
    }

    public final boolean zzg() {
        return this.zzg;
    }

    public final boolean zzh() {
        return (this.zzd & 4) != 0;
    }

    public final boolean zzi() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzj() {
        return (this.zzd & 8) != 0;
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
            return zzlb.zzbL(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzem();
        } else {
            if (i12 == 4) {
                return new zzel((zzeg) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zza;
        }
    }
}
